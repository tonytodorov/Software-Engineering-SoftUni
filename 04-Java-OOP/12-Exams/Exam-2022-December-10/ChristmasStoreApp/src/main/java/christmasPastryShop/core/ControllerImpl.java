package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.BoothRepositoryImpl;
import christmasPastryShop.repositories.CocktailRepositoryImpl;
import christmasPastryShop.repositories.DelicacyRepositoryImpl;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.List;
import java.util.stream.Collectors;

import static christmasPastryShop.common.ExceptionMessages.*;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private final DelicacyRepository<Delicacy> delicacyRepository;
    private final CocktailRepository<Cocktail> cocktailRepository;
    private final BoothRepository<Booth> boothRepository;

    private double totalIncome = 0;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository,
                          CocktailRepository<Cocktail> cocktailRepository,
                          BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
    }

    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = delicacyRepository.getByName(name);

        if (delicacy != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,
                    delicacy.getClass().getSimpleName(), name));
        }

        if (type.equals("Gingerbread")) {
            delicacy = new Gingerbread(name, price);
        } else if (type.equals("Stolen")) {
            delicacy = new Stolen(name, price);
        }

        delicacyRepository.add(delicacy);
        return String.format(DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = cocktailRepository.getByName(name);

        if (cocktail != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,
                    cocktail.getClass().getSimpleName(), name));
        }

        if (type.equals("MulledWine")) {
            cocktail = new MulledWine(name, size, brand);
        } else if (type.equals("Hibernation")) {
            cocktail = new Hibernation(name, size, brand);
        }

        cocktailRepository.add(cocktail);
        return String.format(COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = boothRepository.getByNumber(boothNumber);

        if (booth != null) {
            throw new IllegalArgumentException(String.format(BOOTH_EXIST, boothNumber));
        }

        if (type.equals("OpenBooth")) {
            booth = new OpenBooth(boothNumber, capacity);
        } else if (type.equals("PrivateBooth")) {
            booth = new PrivateBooth(boothNumber, capacity);
        }

        boothRepository.add(booth);
        return String.format(BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Booth currentBoat = boothRepository.getAll().stream()
                .filter(booth -> !booth.isReserved())
                .filter(booth -> booth.getCapacity() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        if (null == currentBoat) {
            return RESERVATION_NOT_POSSIBLE;
        }

        currentBoat.reserve(numberOfPeople);
        return String.format(BOOTH_RESERVED, currentBoat.getBoothNumber(), numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth currentBoat = boothRepository.getByNumber(boothNumber);

        double bill = currentBoat.getBill();
        totalIncome += bill;
        currentBoat.clear();

        return String.format(BILL, boothNumber, bill);
    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME, totalIncome);
    }
}
