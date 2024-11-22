package org.xml.processing.exercises.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xml.processing.exercises.data.entities.Part;

public interface PartRepository extends JpaRepository<Part, Integer> {

}
