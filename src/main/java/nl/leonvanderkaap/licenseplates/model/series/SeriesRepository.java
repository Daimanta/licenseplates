package nl.leonvanderkaap.licenseplates.model.series;

import nl.leonvanderkaap.licenseplates.commons.repositories.PracticalRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeriesRepository extends PracticalRepository<Series, Long>{

    @Query(value = "SELECT * FROM Series as s WHERE UPPER(?1) ~ s.strippedRegex OR  UPPER(?1) ~ s.fullRegex", nativeQuery = true)
    List<Series> findMatchingSeries(String licencePlate);
}
