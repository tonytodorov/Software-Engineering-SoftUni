package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;
    private int countExploredPlanets;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;

        if (type.equals("Biologist")) {
            astronaut = new Biologist(astronautName);
        } else if (type.equals("Geodesist")) {
            astronaut = new Geodesist(astronautName);
        } else if (type.equals("Meteorologist")) {
            astronaut = new Meteorologist(astronautName);
        } else {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        astronautRepository.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);

        planet.getItems().addAll(List.of(items));

        planetRepository.add(planet);

        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut currentAstronaut = astronautRepository.findByName(astronautName);

        if (null == currentAstronaut) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }

        astronautRepository.remove(currentAstronaut);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet currentPlanet = planetRepository.findByName(planetName);

        List<Astronaut> readyAstronaut = astronautRepository.getModels()
                .stream()
                .filter(astronaut -> astronaut.getOxygen() > 60)
                .collect(Collectors.toList());

        if (readyAstronaut.isEmpty()) {
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Mission mission = new MissionImpl();
        mission.explore(currentPlanet, readyAstronaut);

        countExploredPlanets++;

        long numberOfAstronauts = readyAstronaut.stream()
                .filter(astronaut -> !astronaut.canBreath())
                .count();

        return String.format(PLANET_EXPLORED, planetName, numberOfAstronauts);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(REPORT_PLANET_EXPLORED, countExploredPlanets));
        sb.append(System.lineSeparator());
        sb.append(REPORT_ASTRONAUT_INFO);
        sb.append(System.lineSeparator());

        astronautRepository.getModels().forEach(astronaut -> {
            sb.append(String.format(REPORT_ASTRONAUT_NAME, astronaut.getName()));
            sb.append(System.lineSeparator());
            sb.append(String.format(REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen()));
            sb.append(System.lineSeparator());

            if (astronaut.getBag().getItems().isEmpty()) {
                sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, "None"));
                sb.append(System.lineSeparator());
            } else {
                sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS,
                        String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER,
                                astronaut.getBag().getItems())));
                sb.append(System.lineSeparator());
            }
        });

        return sb.toString().trim();
    }
}
