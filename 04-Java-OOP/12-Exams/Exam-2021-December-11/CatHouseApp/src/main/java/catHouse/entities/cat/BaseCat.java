package catHouse.entities.cat;

import catHouse.common.ExceptionMessages;

import static catHouse.common.ExceptionMessages.*;

public abstract class BaseCat implements Cat {

    private String name;
    private String breed;
    private int kilograms;
    private double price;

    protected BaseCat(String name, String breed, int kilograms, double price) {
        this.setName(name);
        this.setBreed(breed);
        this.kilograms = kilograms;
        this.setPrice(price);
    }

    private void setBreed(String breed) {
        if (null == breed || breed.trim().isEmpty()) {
            throw new NullPointerException(CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.breed = breed;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }

        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(CAT_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public int getKilograms() {
        return kilograms;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void eating() {
        if (this.getClass().getSimpleName().equals("ShorthairCat")) {
            this.kilograms += 1;
        } else if (this.getClass().getSimpleName().equals("LonghairCat")) {
            this.kilograms += 3;
        }
    }
}
