package handball.entities.team;

import handball.common.ExceptionMessages;

import static handball.common.ExceptionMessages.*;

public abstract class BaseTeam implements Team {

    private String name;
    private String country;
    private int advantage;

    protected BaseTeam(String name, String country, int advantage) {
        this.setName(name);
        this.setCountry(country);
        this.setAdvantage(advantage);
    }

    @Override
    public void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(TEAM_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    private void setCountry(String country) {
        if (null == country || country.trim().isEmpty()) {
            throw new NullPointerException(TEAM_COUNTRY_NULL_OR_EMPTY);
        }

        this.country = country;
    }

    private void setAdvantage(int advantage) {
        if (advantage <= 0) {
            throw new IllegalArgumentException(TEAM_ADVANTAGE_BELOW_OR_EQUAL_ZERO);
        }

        this.advantage = advantage;
    }

    @Override
    public void play() {
        if (getClass().getSimpleName().equals("Bulgaria")) {
            this.advantage += 115;
        } else if (getClass().getSimpleName().equals("Germany")) {
            this.advantage += 145;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAdvantage() {
        return advantage;
    }
}
