package handball.core;

import handball.common.ConstantMessages;
import handball.common.ExceptionMessages;
import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;
import handball.entities.team.Bulgaria;
import handball.entities.team.Germany;
import handball.entities.team.Team;
import handball.repositories.EquipmentRepository;
import handball.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static handball.common.ConstantMessages.*;
import static handball.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Repository equipment;
    private Collection<Gameplay> gameplays;

    public ControllerImpl() {
        this.equipment = new EquipmentRepository();
        this.gameplays = new ArrayList<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        Gameplay gameplay;

        if (gameplayType.equals("Outdoor")) {
            gameplay = new Outdoor(gameplayName);
        } else if (gameplayType.equals("Indoor")) {
            gameplay = new Indoor(gameplayName);
        } else {
            throw new NullPointerException(INVALID_GAMEPLAY_TYPE);
        }

        gameplays.add(gameplay);

        return String.format(SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment currentEquipment;

        if (equipmentType.equals("Kneepad")) {
            currentEquipment = new Kneepad();
        } else if (equipmentType.equals("ElbowPad")) {
            currentEquipment = new ElbowPad();
        } else {
            throw new IllegalArgumentException(INVALID_EQUIPMENT_TYPE);
        }

        equipment.add(currentEquipment);

        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment byType = equipment.findByType(equipmentType);

        if (null == byType) {
            throw new IllegalArgumentException(String.format(NO_EQUIPMENT_FOUND, equipmentType));
        }

        equipment.remove(byType);

        Gameplay currentGameplay = gameplays.stream()
                .filter(gameplay -> gameplay.getName().equals(gameplayName))
                .findFirst()
                .get();

        currentGameplay.addEquipment(byType);


        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Team team;

        if (teamType.equals("Bulgaria")) {
            team = new Bulgaria(teamName, country, advantage);
        } else if (teamType.equals("Germany")) {
            team = new Germany(teamName, country, advantage);
        } else {
            throw new IllegalArgumentException(INVALID_TEAM_TYPE);
        }

        Gameplay currentGameplay = gameplays.stream()
                .filter(gameplay -> gameplay.getName().equals(gameplayName))
                .findFirst()
                .get();

        if (currentGameplay.getClass().getSimpleName().equals("Outdoor") && teamType.equals("Bulgaria")) {
            currentGameplay.addTeam(team);
        } else if (currentGameplay.getClass().getSimpleName().equals("Indoor") && teamType.equals("Germany")) {
            currentGameplay.addTeam(team);
        } else {
            return GAMEPLAY_NOT_SUITABLE;
        }

        return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
    }

    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay currentGameplay = gameplays.stream()
                .filter(gameplay -> gameplay.getName().equals(gameplayName))
                .findFirst()
                .get();

        currentGameplay.teamsInGameplay();
        int playedTeams = currentGameplay.getTeam().size();

        return String.format(TEAMS_PLAYED, playedTeams);
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        Gameplay currentGameplay = gameplays.stream()
                .filter(gameplay -> gameplay.getName().equals(gameplayName))
                .findFirst()
                .get();

        int value = currentGameplay.getTeam().stream().mapToInt(Team::getAdvantage).sum();

        return String.format(ADVANTAGE_GAMEPLAY, gameplayName, value);
    }

    @Override
    public String getStatistics() {
        return gameplays.toString();
    }
}
