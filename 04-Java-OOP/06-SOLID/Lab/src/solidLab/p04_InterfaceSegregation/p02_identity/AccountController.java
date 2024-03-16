package solidLab.p04_InterfaceSegregation.p02_identity;

import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.Account;
import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.User;
import solidLab.p04_InterfaceSegregation.p02_identity.interfaces.UserRepository;

public class AccountController {

    private final Account account;
    private UserRepository userRepository;

    public AccountController(Account account, UserRepository userRepository) {
        this.account = account;
        this.userRepository = userRepository;
    }

    public void changePassword(String id, String newPass) {
        User user = userRepository.getById(id);
        user.setPassword(newPass);
        userRepository.updatePassword(user);
    }
}
