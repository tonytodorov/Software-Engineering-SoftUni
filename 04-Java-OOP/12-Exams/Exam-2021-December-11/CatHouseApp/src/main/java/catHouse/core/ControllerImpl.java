package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;

        if (type.equals("ShortHouse")) {
            house = new ShortHouse(name);
        } else if (type.equals("LongHouse")) {
            house = new LongHouse(name);
        } else {
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        }

        houses.add(house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;

        if (type.equals("Ball")) {
            toy = new Ball();
        } else if (type.equals("Mouse")) {
            toy = new Mouse();
        } else {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }

        toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy;

        if (toyType.equals("Ball")) {
            toy = new Ball();
        } else if (toyType.equals("Mouse")) {
            toy = new Mouse();
        } else {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        House currentHouse = houses.stream()
                .filter(house -> house.getName().equals(houseName))
                .findFirst()
                .orElse(null);

        if (null != currentHouse) {
            currentHouse.buyToy(toy);
            toys.removeToy(toy);
        }

        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;

        if (catType.equals("ShorthairCat")) {
            cat = new ShorthairCat(catName, catBreed, price);
        } else if (catType.equals("LonghairCat")) {
            cat = new LonghairCat(catName, catBreed, price);
        } else {
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }

        House currentHouse = houses.stream()
                .filter(house -> house.getName().equals(houseName))
                .findFirst()
                .orElse(null);

        if (catType.equals("ShorthairCat") && currentHouse.getClass().getSimpleName().equals("ShortHouse")) {
            currentHouse.addCat(cat);
        } else if (catType.equals("LonghairCat") && currentHouse.getClass().getSimpleName().equals("LongHouse")) {
            currentHouse.addCat(cat);
        } else {
            return UNSUITABLE_HOUSE;
        }

        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        House currentHouse = houses.stream()
                .filter(house -> house.getName().equals(houseName))
                .findFirst()
                .orElse(null);

        currentHouse.feeding();
        return String.format(FEEDING_CAT, currentHouse.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House currentHouse = houses.stream()
                .filter(house -> house.getName().equals(houseName))
                .findFirst()
                .orElse(null);

        double toysPrice = currentHouse.getToys()
                .stream()
                .mapToDouble(Toy::getPrice)
                .sum();

        double catsPrice = currentHouse.getCats()
                .stream()
                .mapToDouble(Cat::getPrice)
                .sum();

        double totalPrice = toysPrice + catsPrice;

        return String.format(VALUE_HOUSE, houseName, totalPrice);
    }

    @Override
    public String getStatistics() {
        return houses.stream()
                .map(House::getStatistics)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
