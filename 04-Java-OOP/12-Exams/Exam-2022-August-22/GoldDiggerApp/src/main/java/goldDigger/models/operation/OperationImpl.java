package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.Collection;

public class OperationImpl implements Operation {

    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {

        Collection<String> exhibits = spot.getExhibits();

        discoverers.forEach(discoverer -> {
            while (discoverer.canDig() && exhibits.iterator().hasNext()) {
                discoverer.dig();
                String exhibit = exhibits.iterator().next();
                discoverer.getMuseum().getExhibits().add(exhibit);
                exhibits.remove(exhibit);
            }
        });

    }
}
