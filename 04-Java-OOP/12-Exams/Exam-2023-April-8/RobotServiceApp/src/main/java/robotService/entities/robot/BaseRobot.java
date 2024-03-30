package robotService.entities.robot;

import static robotService.common.ExceptionMessages.*;

public abstract class BaseRobot implements Robot {

    private String name;
    private String kind;
    private int kilograms;
    private double price;

    protected BaseRobot(String name, String kind, int kilograms, double price) {
        this.setName(name);
        this.setKind(kind);
        this.kilograms = kilograms;
        this.setPrice(price);
    }

    private void setKind(String kind) {
        if (null == kind || kind.trim().isEmpty()) {
            throw new NullPointerException(ROBOT_KIND_CANNOT_BE_NULL_OR_EMPTY);
        }

        this.kind = kind;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ROBOT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
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
            throw new NullPointerException(ROBOT_NAME_CANNOT_BE_NULL_OR_EMPTY);
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
        if (getClass().getSimpleName().equals("FemaleRobot")) {
            this.kilograms += 1;
        } else if (getClass().getSimpleName().equals("MaleRobot")) {
            this.kilograms += 3;
        }
    }
}
