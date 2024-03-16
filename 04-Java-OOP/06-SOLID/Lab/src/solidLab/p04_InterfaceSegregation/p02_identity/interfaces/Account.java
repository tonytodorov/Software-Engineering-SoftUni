package solidLab.p04_InterfaceSegregation.p02_identity.interfaces;

public interface Account {

    void login(String username, String password);

    void register(String username, String password);
    Iterable<User> getAllUsersOnline();

    Iterable<User> getAllUsers();

    boolean getRequireUniqueEmail();

    int getMinRequiredPasswordLength();

    int getMaxRequiredPasswordLength();

}

