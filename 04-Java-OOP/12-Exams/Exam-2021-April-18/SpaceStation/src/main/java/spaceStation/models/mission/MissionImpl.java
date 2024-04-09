package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission {

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        Collection<String> items = planet.getItems();

        astronauts.forEach(astronaut -> {
            while (astronaut.canBreath() && items.iterator().hasNext()) {
                astronaut.breath();
                String item = items.iterator().next();
                astronaut.getBag().getItems().add(item);
                items.remove(item);
            }
        });
    }
}
