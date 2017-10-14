package nl.leonvanderkaap.licenseplates.model.masterdata;

import nl.leonvanderkaap.licenseplates.commons.repositories.PracticalRepository;

import java.util.List;

public interface CountryRepository extends PracticalRepository<Country, String> {

    List<Country> findAll();
}
