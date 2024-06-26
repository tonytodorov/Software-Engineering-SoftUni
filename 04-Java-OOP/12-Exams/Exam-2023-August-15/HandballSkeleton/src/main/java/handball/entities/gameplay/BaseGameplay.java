package handball.entities.gameplay;

import handball.entities.equipment.Equipment;
import handball.entities.team.Team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static handball.common.ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY;
import static handball.common.ExceptionMessages.TEAM_NAME_NULL_OR_EMPTY;

public abstract class BaseGameplay implements Gameplay {

    private String name;
    private int capacity;
    private Collection<Equipment> equipments;
    private Collection<Team> teams;

    protected BaseGameplay(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.equipments = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(GAMEPLAY_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public int allProtection() {
        return equipments.stream()
                .mapToInt(Equipment::getProtection)
                .sum();
    }

    @Override
    public void addTeam(Team team) {
        teams.add(team);
    }

    @Override
    public void removeTeam(Team team) {
        teams.remove(team);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    @Override
    public void teamsInGameplay() {
        teams.forEach(Team::play);
    }

    @Override
    public Collection<Team> getTeam() {
        return teams;
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return equipments;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        String teamInfo = "Team: " + ((teams.isEmpty())
                ? "none"
                : teams.stream().map(Team::getName).collect(Collectors.joining(" ")));


        return String.format("%s %s%n" +
                "%s%n" +
                "Equipment: %d, Protection: %d",
                this.name,
                this.getClass().getSimpleName(),
                teamInfo,
                this.equipments.size(),
                allProtection());
    }


}
