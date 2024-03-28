package harpoonDiver.repositories;

import harpoonDiver.models.divingSite.DivingSite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DivingSiteRepository implements Repository<DivingSite> {

    private Collection<DivingSite> divingSiteCollection;

    public DivingSiteRepository() {
        this.divingSiteCollection = new ArrayList<>();
    }

    @Override
    public Collection<DivingSite> getCollection() {
        return Collections.unmodifiableCollection(divingSiteCollection);
    }

    @Override
    public void add(DivingSite entity) {
        divingSiteCollection.add(entity);
    }

    @Override
    public boolean remove(DivingSite entity) {
        return divingSiteCollection.remove(entity);
    }

    @Override
    public DivingSite byName(String name) {
        return divingSiteCollection.stream()
                .filter(divingSite -> divingSite.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
