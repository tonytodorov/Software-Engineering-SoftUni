package climbers.repositories;

import climbers.models.climber.Climber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ClimberRepository implements Repository<Climber> {

    private Collection<Climber> climber;

    public ClimberRepository() {
        this.climber = new ArrayList<>();
    }

    @Override
    public Collection<Climber> getCollection() {
        return Collections.unmodifiableCollection(climber);
    }

    @Override
    public void add(Climber entity) {
        climber.add(entity);
    }

    @Override
    public boolean remove(Climber entity) {
        return climber.remove(entity);
    }

    @Override
    public Climber byName(String name) {
        return climber.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
