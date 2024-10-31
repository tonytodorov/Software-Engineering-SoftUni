package org.example.orm;

import org.example.orm.entities.User;
import org.example.orm.orm.config.MyConnector;
import org.example.orm.orm.context.EntityManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        MyConnector.createConnection("root", "Tonytodorov431", "soft_uni");

        Connection connection = MyConnector.getConnection();
        EntityManager<User> em = new EntityManager<>(connection);

        User user1 = new User("user", "pass", 20, LocalDate.now());
        User user2 = new User("user2", "pass2", 22, LocalDate.now());
        user2.setId(2);

        User firstUser = em.findFirst(User.class);

        firstUser.setUsername("updated");
        em.persist(firstUser);
        System.out.println();

        Iterable<User> users = em.find(User.class);

        for (User user : users) {
            System.out.println(user);
        }

        System.out.println();

    }
}