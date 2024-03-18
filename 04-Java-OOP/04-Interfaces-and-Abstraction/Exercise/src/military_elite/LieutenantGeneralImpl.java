package military_elite;

import java.util.Collection;
import java.util.Collections;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private Collection<Private> privateSet;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary, Collection<Private> privateSet) {
        super(id, firstName, lastName, salary);
        this.privateSet = privateSet;
    }

    @Override
    public Collection<Private> getPrivates() {
        return Collections.unmodifiableCollection(this.privateSet);
    }

    @Override
    public void addPrivate(Private priv) {
        this.privateSet.add(priv);
    }
}
