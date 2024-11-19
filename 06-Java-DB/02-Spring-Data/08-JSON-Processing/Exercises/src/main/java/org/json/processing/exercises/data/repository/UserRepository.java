package org.json.processing.exercises.data.repository;

import org.json.processing.exercises.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Set<User> findAllBySoldIsNotNull();

    Set<User> findAllBySoldIsNotNullOrderBySoldDesc();
}
