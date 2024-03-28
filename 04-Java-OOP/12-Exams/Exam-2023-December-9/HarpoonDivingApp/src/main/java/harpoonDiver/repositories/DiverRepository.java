package harpoonDiver.repositories;

import harpoonDiver.models.diver.Diver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DiverRepository implements Repository<Diver> {

    private Collection<Diver> diverCollection;

    public DiverRepository() {
        this.diverCollection = new ArrayList<>();
    }

    @Override
    public Collection<Diver> getCollection() {
        return Collections.unmodifiableCollection(diverCollection);
    }

    @Override
    public void add(Diver entity) {
        diverCollection.add(entity);
    }

    @Override
    public boolean remove(Diver entity) {
        return diverCollection.remove(entity);
    }

    @Override
    public Diver byName(String name) {
        return diverCollection.stream()
                .filter(diver -> diver.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
