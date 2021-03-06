package nl.leonvanderkaap.licenseplates.commons.repositories;

import nl.leonvanderkaap.licenseplates.model.masterdata.Country;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface PracticalRepository<T, ID extends Serializable> extends Repository<T, ID> {

    List<T> findAll();
    Optional<T> findOne(ID id);

    void save(T type);
}
