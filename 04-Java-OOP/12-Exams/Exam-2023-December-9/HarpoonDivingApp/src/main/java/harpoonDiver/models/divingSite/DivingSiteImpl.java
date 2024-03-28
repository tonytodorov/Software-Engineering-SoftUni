package harpoonDiver.models.divingSite;

import java.util.ArrayList;
import java.util.Collection;

import static harpoonDiver.common.ExceptionMessages.*;

public class DivingSiteImpl implements DivingSite {

    private String name;
    private Collection<String> seaCreatures;
    public DivingSiteImpl(String name) {
        this.setName(name);
        this.seaCreatures = new ArrayList<>();
    }

    private void setName(String name) {
        if (null == name || name.trim().isEmpty()) {
            throw new NullPointerException(SITE_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public Collection<String> getSeaCreatures() {
        return seaCreatures;
    }

    @Override
    public String getName() {
        return name;
    }
}
