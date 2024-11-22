package org.xml.processing.exercises.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xml.processing.exercises.data.entities.Car;

import java.util.LinkedHashSet;
import java.util.Set;

public interface CarRepository extends JpaRepository<Car, Integer> {

    Set<Car> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make);
}
