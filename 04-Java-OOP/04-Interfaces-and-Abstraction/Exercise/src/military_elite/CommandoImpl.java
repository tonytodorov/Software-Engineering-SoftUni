package military_elite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private Collection<Mission> missionSet;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corp, Collection<Mission> missionSet) {
        super(id, firstName, lastName, salary, corp);
        setMissionSet(missionSet);
    }

    private void setMissionSet(Collection<Mission> missionSet) {
        if (null == missionSet) {
            this.missionSet = new ArrayList<>();
        } else {
            this.missionSet = missionSet;
        }
    }

    @Override
    public void addMission(Mission mission) {
        this.missionSet.add(mission);
    }

    @Override
    public Collection<Mission> getMission() {
        return Collections.unmodifiableCollection(this.missionSet);
    }
}
