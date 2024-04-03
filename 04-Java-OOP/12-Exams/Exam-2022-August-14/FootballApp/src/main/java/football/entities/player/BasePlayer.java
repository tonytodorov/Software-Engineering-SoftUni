package football.entities.player;

import football.common.ExceptionMessages;

import static football.common.ExceptionMessages.*;

public abstract class BasePlayer implements Player {

    private String name;
    private String nationality;
    private double kg;
    private int strength;

    protected BasePlayer(String name, String nationality, double kg, int strength) {
        this.setName(name);
        this.setNationality(nationality);
        this.kg = kg;
        this.setStrength(strength);
    }

    @Override
    public void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setNationality(String nationality) {
        if (null == nationality || nationality.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NATIONALITY_NULL_OR_EMPTY);
        }

        this.nationality = nationality;
    }

    private void setStrength(int strength) {
        if (strength <= 0) {
            throw new IllegalArgumentException(PLAYER_STRENGTH_BELOW_OR_EQUAL_ZERO);
        }

        this.strength = strength;
    }

    @Override
    public void stimulation() {
        if (this.getClass().getSimpleName().equals("Women")) {
            this.strength += 115;
        } else if (this.getClass().getSimpleName().equals("Men")) {
            this.strength += 145;
        }
    }

    @Override
    public double getKg() {
        return kg;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStrength() {
        return strength;
    }
}
