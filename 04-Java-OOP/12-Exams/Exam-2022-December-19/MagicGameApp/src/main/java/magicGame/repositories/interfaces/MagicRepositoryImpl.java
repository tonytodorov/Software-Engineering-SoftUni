package magicGame.repositories.interfaces;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static magicGame.common.ExceptionMessages.*;

public class MagicRepositoryImpl implements MagicRepository<Magic> {

    private Collection<Magic> data;

    public MagicRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magic> getData() {
        return data;
    }

    @Override
    public void addMagic(Magic model) {
        if (null == model) {
            throw new NullPointerException(INVALID_MAGICIAN_REPOSITORY);
        }

        data.add(model);
    }

    @Override
    public boolean removeMagic(Magic model) {
        return data.remove(model);
    }

    @Override
    public Magic findByName(String name) {
        return data.stream()
                .filter(magic -> magic.getName().equals(name))
                .findFirst()
                .orElse(null);

    }
}
