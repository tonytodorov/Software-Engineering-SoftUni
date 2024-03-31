package magicGame.repositories.interfaces;

import magicGame.common.ExceptionMessages;
import magicGame.models.magicians.Magician;

import java.util.Collection;

import static magicGame.common.ExceptionMessages.*;

public class MagicianRepositoryImpl implements MagicianRepository<Magician> {

    private Collection<Magician> data;

    @Override
    public Collection<Magician> getData() {
        return data;
    }

    @Override
    public void addMagician(Magician model) {
        if (null == model) {
            throw new NullPointerException(INVALID_MAGICIAN_REPOSITORY);
        }

        data.add(model);
    }

    @Override
    public boolean removeMagician(Magician model) {
        return data.remove(model);
    }

    @Override
    public Magician findByUsername(String name) {
        return data.stream()
                .filter(magician -> magician.getUsername().equals(name))
                .findFirst()
                .orElse(null);
    }
}
