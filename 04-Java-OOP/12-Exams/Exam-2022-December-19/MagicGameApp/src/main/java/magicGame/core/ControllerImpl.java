package magicGame.core;

import magicGame.common.ExceptionMessages;
import magicGame.common.OutputMessages;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.repositories.interfaces.MagicRepositoryImpl;
import magicGame.repositories.interfaces.MagicianRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;

import static magicGame.common.ExceptionMessages.*;
import static magicGame.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private MagicRepositoryImpl magics;
    private MagicianRepositoryImpl magicians;
    private Region region;

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        Magic magic;

        if (type.equals("RedMagic")) {
            magic = new RedMagic(name, bulletsCount);
        } else if (type.equals("BlackMagic")) {
            magic = new BlackMagic(name, bulletsCount);
        } else {
            throw new IllegalArgumentException(INVALID_MAGIC_TYPE);
        }

        magics.addMagic(magic);
        return String.format(SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magician magician;

        Magic magic = magics.findByName(magicName);

        if (null == magic) {
            throw new NullPointerException(MAGIC_CANNOT_BE_FOUND);
        }

        if (type.equals("Wizard")) {
            magician = new Wizard(username, health, protection, true, magic);
        } else if (type.equals("BlackWidow")) {
            magician = new BlackWidow(username, health, protection, true, magic);
        } else {
            throw new IllegalArgumentException(INVALID_MAGICIAN_TYPE);
        }

        magicians.addMagician(magician);
        return String.format(SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {
        List<Magician> aliveMagicians = magicians.getData()
                .stream()
                .filter(Magician::isAlive)
                .collect(Collectors.toList());

        return "";
    }

    @Override
    public String report() {
        return magicians.toString();
    }
}
