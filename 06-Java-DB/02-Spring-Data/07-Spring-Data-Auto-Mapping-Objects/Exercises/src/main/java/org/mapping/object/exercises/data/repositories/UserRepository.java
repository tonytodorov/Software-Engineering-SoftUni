package org.mapping.object.exercises.data.repositories;

import org.mapping.object.exercises.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);
}
