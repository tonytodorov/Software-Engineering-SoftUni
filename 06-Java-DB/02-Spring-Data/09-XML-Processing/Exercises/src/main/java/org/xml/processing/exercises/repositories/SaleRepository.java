package org.xml.processing.exercises.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xml.processing.exercises.data.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

}
