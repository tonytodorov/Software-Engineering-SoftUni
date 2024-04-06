package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

import static christmasRaces.common.ExceptionMessages.*;

public abstract class BaseCar implements Car {

    private String model;
    private int horsePower;
    private double cubicCentimeters;

    protected BaseCar(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.cubicCentimeters = cubicCentimeters;
    }

    private void setModel(String model) {
        if (null == model || model.trim().isEmpty() || model.length() < 4) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, 4));
        }

        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        if (this.getClass().getSimpleName().equals("MuscleCar") && (horsePower < 400 || horsePower > 600)) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        } else if (this.getClass().getSimpleName().equals("SportsCar") && (horsePower < 250 || horsePower > 450)) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }

        this.horsePower = horsePower;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return cubicCentimeters / (horsePower * laps);
    }
}
