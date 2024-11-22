package org.xml.processing.exercises.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.xml.processing.exercises.data.entities.Customer;

import java.util.Set;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT c FROM Customer c ORDER BY c.birthDate, c.isYoungDriver DESC")
    Set<Customer> findAllByOrderByBirthDateAscIsYoungDriverDesc();
}
