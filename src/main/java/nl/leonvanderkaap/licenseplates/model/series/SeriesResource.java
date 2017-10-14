package nl.leonvanderkaap.licenseplates.model.series;

import nl.leonvanderkaap.licenseplates.commons.exceptions.NotFoundException;
import nl.leonvanderkaap.licenseplates.model.masterdata.Country;
import nl.leonvanderkaap.licenseplates.model.masterdata.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;


@RestController
@RequestMapping("/series")
public class SeriesResource {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private EntityManager entityManager;

    @RequestMapping(method = RequestMethod.POST,
                    consumes = "application/json",
                    produces = "application/json")
    @Transactional
    public ResponseEntity<SeriesDTO> create(@RequestBody SeriesDTO seriesDTO) {
        Optional<Country> countryOptional = countryRepository.findOne(seriesDTO.getCountry());
        Country country;
        if (!countryOptional.isPresent()) {
            throw new NotFoundException("");
        } else {
            country = countryOptional.get();
        }
        Series series = new Series(country, seriesDTO.getName(), seriesDTO.getStrippedRegex(), seriesDTO.getFullRegex());
        entityManager.persist(series);
        return ResponseEntity.ok(new SeriesDTO(series));
    }
}
