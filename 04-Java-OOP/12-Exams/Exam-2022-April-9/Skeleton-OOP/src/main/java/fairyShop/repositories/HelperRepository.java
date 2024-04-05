package fairyShop.repositories;

import fairyShop.models.Helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HelperRepository implements Repository<Helper> {

    private Collection<Helper> helpers;

    public HelperRepository() {
        this.helpers = new ArrayList<>();
    }

    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(helpers);
    }

    @Override
    public void add(Helper model) {
        helpers.add(model);
    }

    @Override
    public boolean remove(Helper model) {
        return helpers.remove(model);
    }

    @Override
    public Helper findByName(String name) {
        return helpers.stream()
                .filter(helper -> helper.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
