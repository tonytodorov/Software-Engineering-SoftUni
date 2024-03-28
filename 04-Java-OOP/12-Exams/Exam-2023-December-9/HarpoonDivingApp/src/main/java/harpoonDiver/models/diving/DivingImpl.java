package harpoonDiver.models.diving;

import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;

public class DivingImpl implements Diving {

    public void searching(DivingSite divingSite, Collection<Diver> divers) {

        Collection<String> seaCreatures = divingSite.getSeaCreatures();

        divers.forEach(diver -> {
            while (diver.canDive() && seaCreatures.iterator().hasNext()) {
                diver.shoot();
                String next = seaCreatures.iterator().next();
                diver.getSeaCatch().getSeaCreatures().add(next);
                seaCreatures.remove(next);
            }
        });

    }


}
