package nl.leonvanderkaap.model.masterdata;

import nl.leonvanderkaap.commons.repositories.PracticalRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends PracticalRepository<Country, String> {

    List<Country> findAll();
}
