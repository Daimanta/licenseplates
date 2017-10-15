package nl.leonvanderkaap.licenseplates.model.series;

import nl.leonvanderkaap.licenseplates.commons.exceptions.NotFoundException;
import nl.leonvanderkaap.licenseplates.model.masterdata.Country;
import nl.leonvanderkaap.licenseplates.model.masterdata.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/series")
public class SeriesResource {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private SeriesService seriesService;

    @RequestMapping(method = RequestMethod.POST,
                    consumes = "application/json",
                    produces = "application/json")
    @Transactional
    public ResponseEntity<SeriesDTO> create(@RequestBody @Valid SeriesDTO seriesDTO) {
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

    @RequestMapping(path = "{id}",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    @Transactional
    public ResponseEntity<SeriesDTO> update(@RequestParam(value = "id", required = true) long id,
                                            @RequestBody @Valid SeriesDTO seriesDTO) {
        Series series = seriesRepository.findOne(id).orElseThrow(() -> (new NotFoundException("")));
        seriesService.update(series, seriesDTO);
        return ResponseEntity.ok(new SeriesDTO(series));
    }

    @RequestMapping(path = "match",
            method = RequestMethod.GET,
            produces = "application/json")
    @Transactional
    public ResponseEntity<List<SeriesDTO>> findMatchingSeries(@RequestParam(value = "licenseplate", required = true) String licensePlate) {
        return ResponseEntity.ok(this.seriesRepository.findMatchingSeries(licensePlate)
                .stream().map(SeriesDTO::new).collect(Collectors.toList()));
    }
}
