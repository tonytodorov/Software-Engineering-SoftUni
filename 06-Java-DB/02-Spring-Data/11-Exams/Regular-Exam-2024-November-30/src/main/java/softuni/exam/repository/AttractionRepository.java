package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Attraction;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Long> {

    Optional<Attraction> findByName(String name);

    @Query("SELECT a" +
            " FROM Attraction a" +
            " JOIN a.country c" +
            " WHERE a.type IN('historical site', 'archaeological site')" +
            " AND a.elevation >= 300" +
            " ORDER BY a.name ASC, c.name ASC")
    List<Attraction> findHistoricalAndArchaeologicalSitesWithElevation();
}
