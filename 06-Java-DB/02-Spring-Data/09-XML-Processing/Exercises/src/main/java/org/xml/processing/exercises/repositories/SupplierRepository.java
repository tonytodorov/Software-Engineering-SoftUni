package org.xml.processing.exercises.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xml.processing.exercises.data.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
