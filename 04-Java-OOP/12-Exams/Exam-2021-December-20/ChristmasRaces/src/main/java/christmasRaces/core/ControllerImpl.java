package christmasRaces.core;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.common.OutputMessages;
import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.CarRepository;
import christmasRaces.repositories.DriverRepository;
import christmasRaces.repositories.RaceRepository;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private final Repository<Driver> driverRepository;
    private final Repository<Car> carRepository;
    private final Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver currentDriver = new DriverImpl(driver);
        Driver driverByName = driverRepository.getByName(driver);

        if (driverByName != null) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver));
        }

        driverRepository.add(currentDriver);
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car;

        if (type.equals("Muscle")) {
            car = new MuscleCar(model, horsePower);
        } else if (type.equals("Sports")) {
            car = new SportsCar(model, horsePower);
        } else {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, model));
        }

        carRepository.add(car);
        return String.format(CAR_CREATED, this.getClass().getSimpleName(), model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driverByName = driverRepository.getByName(driverName);
        Car carByModel = carRepository.getByName(carModel);

        if (null == driverByName) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        } else if (null == carByModel) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, carModel));
        }

        driverByName.addCar(carByModel);
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race raceByName = raceRepository.getByName(raceName);
        Driver driverByName = driverRepository.getByName(driverName);

        if (null == raceByName) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        } else if (null == driverByName) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND, driverName));
        }

        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);

        if (null == race) {
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND, raceName));
        }

        Collection<Driver> drivers = race.getDrivers();

        if (drivers.size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }

        drivers.forEach(driver -> {
            if (driver.getCanParticipate()) {
                driver.getCar().calculateRacePoints(race.getLaps());
                driver.winRace();
            }
        });

        List<Driver> driverList = drivers.stream()
                .sorted(Comparator.comparing(driver -> driver.getCar().calculateRacePoints(race.getLaps())))
                .collect(Collectors.toList());

        String result = String.format(DRIVER_FIRST_POSITION,
                driverList.get(driverList.size() - 1).getName(), race.getName()) + System.lineSeparator() +
                String.format(DRIVER_SECOND_POSITION,
                        driverList.get(driverList.size() - 2).getName(), race.getName()) + System.lineSeparator() +
                String.format(DRIVER_THIRD_POSITION,
                        driverList.get(driverList.size() - 3).getName(), race.getName()) + System.lineSeparator();

        this.raceRepository.remove(race);

        return result;
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);

        Race raceByName = raceRepository.getByName(race.getName());

        if (null != raceByName) {
            throw new IllegalArgumentException(String.format(RACE_EXISTS, name));
        }

        raceRepository.add(race);
        return String.format(RACE_CREATED, name);
    }
}
