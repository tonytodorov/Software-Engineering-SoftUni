package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;

        if (fieldType.equals("ArtificialTurf")) {
            field = new ArtificialTurf(fieldName);
        } else if (fieldType.equals("NaturalGrass")) {
            field = new NaturalGrass(fieldName);
        } else {
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }


        fields.add(field);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement currentSupplement;

        if (type.equals("Powdered")) {
            currentSupplement = new Powdered();
        } else if (type.equals("Liquid")) {
            currentSupplement = new Liquid();
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }

        supplement.add(currentSupplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement currentSupplement = supplement.findByType(supplementType);

        if (null == currentSupplement) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }

        Field currentField = fields.stream()
                .filter(field -> field.getName().equals(fieldName))
                .findFirst().orElse(null);

        if (null != currentField) {
            currentField.getSupplements().add(currentSupplement);
            supplement.remove(currentSupplement);
        }

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;

        if (playerType.equals("Women")) {
            player = new Women(playerName, nationality, strength);
        } else if (playerType.equals("Men")) {
            player = new Men(playerName, nationality, strength);
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        Field currentField = fields.stream()
                .filter(field -> field.getName().equals(fieldName))
                .findFirst().get();

        if (playerType.equals("Women") && currentField.getClass().getSimpleName().equals("ArtificialTurf")) {
            currentField.addPlayer(player);
        } else if (playerType.equals("Men") && currentField.getClass().getSimpleName().equals("NaturalGrass")) {
            currentField.addPlayer(player);
        } else {
            return FIELD_NOT_SUITABLE;
        }

        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field currentField = fields.stream()
                .filter(field -> field.getName().equals(fieldName))
                .findFirst().get();

        currentField.drag();

        return String.format(PLAYER_DRAG, currentField.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field currentField = fields.stream()
                .filter(field -> field.getName().equals(fieldName))
                .findFirst().get();

        int strengthSum = currentField.getPlayers()
                .stream()
                .mapToInt(Player::getStrength)
                .sum();

        return String.format(STRENGTH_FIELD, fieldName, strengthSum);
    }

    @Override
    public String getStatistics() {
        return fields.stream()
                .map(Field::getInfo)
                .collect(Collectors.joining(""));
    }
}
