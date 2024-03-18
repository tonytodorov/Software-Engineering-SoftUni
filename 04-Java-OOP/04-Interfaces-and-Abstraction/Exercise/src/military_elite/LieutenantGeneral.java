package military_elite;

import java.util.Collection;

public interface LieutenantGeneral {

    Collection<Private> getPrivates();
    void addPrivate(Private priv);
}
