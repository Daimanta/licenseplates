package nl.leonvanderkaap.licenseplates.model.series;

import nl.leonvanderkaap.licenseplates.commons.repositories.PracticalRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeriesRepository extends PracticalRepository<Series, Long>{

    @Query(value = "SELECT * FROM series WHERE ?1 ~* stripped_regex OR ?1 ~* full_regex",
            nativeQuery = true)
    List<Series> findMatchingSeries(String licencePlate);
}
