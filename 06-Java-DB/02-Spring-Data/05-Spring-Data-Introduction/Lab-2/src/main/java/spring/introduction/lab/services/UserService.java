package spring.introduction.lab.services;

import spring.introduction.lab.entities.User;

public interface UserService {

    void register(User user);

    User get(int id);

    void addAccountWithBalance(User user, int balance);

    User getByAccount(int accountId);
}
