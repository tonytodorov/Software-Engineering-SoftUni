package military_elite;

import java.util.Collection;

public interface Commando {

    void addMission(Mission mission);
    Collection<Mission> getMission();
}
