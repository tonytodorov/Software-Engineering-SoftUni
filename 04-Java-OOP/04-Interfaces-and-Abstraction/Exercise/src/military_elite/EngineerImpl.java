package military_elite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private Collection<Repair> repairSet;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corp,
                        String partName, int workedHours, Collection<Repair> repairSet) {
        super(id, firstName, lastName, salary, corp);
        setRepairSet(repairSet);
    }

    private void setRepairSet(Collection<Repair> repairSet) {
        if (null == repairSet) {
            this.repairSet = new ArrayList<>();
        } else {
            this.repairSet = repairSet;
        }
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairSet.add(repair);
    }
    @Override
    public Collection<Repair> getRepairs() {
        return Collections.unmodifiableCollection(this.repairSet);
    }

}
