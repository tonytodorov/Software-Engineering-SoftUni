package football_team_generator;

public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.name = name;
        this.endurance = endurance;
        this.sprint = sprint;
        this.dribble = dribble;
        this.passing = passing;
        this.shooting = shooting;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEndurance(int endurance) {
        if (!validateStat(endurance)) {
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }

        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if (!validateStat(sprint)) {
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }

        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (!validateStat(dribble)) {
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }

        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (!validateStat(passing)) {
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }

        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (!validateStat(shooting)) {
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }

        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.00;
    }

    private boolean validateStat(int stat) {
        return stat >= 0 && stat <= 100;
    }
}
