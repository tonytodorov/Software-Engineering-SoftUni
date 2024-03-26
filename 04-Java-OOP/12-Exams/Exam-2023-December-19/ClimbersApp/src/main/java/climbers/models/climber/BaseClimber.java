package climbers.models.climber;

import climbers.common.ExceptionMessages;
import climbers.models.roster.Roster;
import climbers.models.roster.RosterImpl;

import static climbers.common.ExceptionMessages.*;

public abstract class BaseClimber implements Climber {

    private String name;
    private double strength;
    private Roster roster;

    public BaseClimber(String name, double strength) {
        this.setName(name);
        this.setStrength(strength);
        this.roster = new RosterImpl();
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(CLIMBER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setStrength(double strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(CLIMBER_STRENGTH_LESS_THAN_ZERO);
        }

        this.strength = strength;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getStrength() {
        return strength;
    }

    @Override
    public boolean canClimb() {
        return this.strength > 0;
    }

    @Override
    public Roster getRoster() {
        return roster;
    }

    @Override
    public void climb() {
        if (this.strength < 0) {
            this.strength = 0;
        } else if (getClass().getSimpleName().equals("WallClimber")) {
            this.setStrength(this.getStrength() - 30);
        } else if (getClass().getSimpleName().equals("RockClimber")) {
            this.setStrength(this.getStrength() - 60);
        }
    }
}
