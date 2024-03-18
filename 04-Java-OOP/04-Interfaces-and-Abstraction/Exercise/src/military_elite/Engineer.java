package military_elite;

import java.util.Collection;

public interface Engineer {

    void addRepair(Repair repair);
    Collection<Repair> getRepairs();
}
