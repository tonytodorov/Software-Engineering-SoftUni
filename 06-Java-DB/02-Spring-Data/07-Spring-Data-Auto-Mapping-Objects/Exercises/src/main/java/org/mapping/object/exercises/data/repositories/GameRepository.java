package org.mapping.object.exercises.data.repositories;

import org.mapping.object.exercises.data.entities.Game;
import org.mapping.object.exercises.service.dtos.GameDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    Optional<Game> findByTitle(String title);
}
