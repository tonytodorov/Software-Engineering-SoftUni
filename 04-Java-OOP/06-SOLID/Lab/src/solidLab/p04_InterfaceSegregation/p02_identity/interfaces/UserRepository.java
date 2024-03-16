package solidLab.p04_InterfaceSegregation.p02_identity.interfaces;

public interface UserRepository {

    Iterable<User> getAllUsersOnline();

    Iterable<User> getAllUsers();

    User getUserByName(String name);

    User getById(String id);

    void updatePassword(User user);
}
