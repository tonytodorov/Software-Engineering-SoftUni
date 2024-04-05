package fairyShop.models;

import fairyShop.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

import static fairyShop.common.ExceptionMessages.*;

public abstract class BaseHelper implements Helper {

    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    protected BaseHelper(String name, int energy) {
        this.setName(name);
        this.energy = energy;
        this.instruments = new ArrayList<>();
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(HELPER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public void work() {
        if (this.getClass().getSimpleName().equals("Sleepy")) {
            this.energy -= 15;
        } else {
            this.energy -= 10;
        }

        if (this.energy < 0) {
            this.energy = 0;
        }
    }

    @Override
    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.energy > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return instruments;
    }

    @Override
    public String toString() {
        return String.format("Helpers info:%n" +
                "Name: %s%n" +
                "Energy: %d%n" +
                "Instruments: %d not broken left",
                this.name,
                this.energy,
                instruments.stream()
                        .filter(instrument -> instrument.getPower() > 0)
                        .count());
    }
}
