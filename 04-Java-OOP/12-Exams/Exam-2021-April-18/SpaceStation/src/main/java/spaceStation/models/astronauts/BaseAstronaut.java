package spaceStation.models.astronauts;

import spaceStation.common.ExceptionMessages;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import static spaceStation.common.ExceptionMessages.*;

public abstract class BaseAstronaut implements Astronaut {

    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }

        this.oxygen = oxygen;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public boolean canBreath() {
        return oxygen > 0;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    @Override
    public void breath() {
        if (this.getClass().getSimpleName().equals("Biologist")) {
            this.oxygen -= 5;
        } else {
            this.oxygen -= 10;
        }

        if (this.oxygen < 0) {
            this.oxygen = 0;
        }
    }
}
