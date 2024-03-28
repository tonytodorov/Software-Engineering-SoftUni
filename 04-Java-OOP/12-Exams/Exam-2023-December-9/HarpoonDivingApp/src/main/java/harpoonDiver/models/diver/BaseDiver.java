package harpoonDiver.models.diver;

import harpoonDiver.models.seaCatch.SeaCatch;
import harpoonDiver.models.seaCatch.BaseSeaCatch;

import static harpoonDiver.common.ExceptionMessages.*;

public abstract class BaseDiver implements Diver {

    private String name;
    private double oxygen;
    private SeaCatch seaCatch;

    public BaseDiver(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.seaCatch = new BaseSeaCatch();
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(DIVER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(DIVER_OXYGEN_LESS_THAN_ZERO);
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
    public boolean canDive() {
        return this.oxygen > 0;
    }

    @Override
    public SeaCatch getSeaCatch() {
        return seaCatch;
    }

    @Override
    public void shoot() {
        this.oxygen -= 30;

        if (this.oxygen < 0) {
            this.oxygen = 0;
        }
    }
}
