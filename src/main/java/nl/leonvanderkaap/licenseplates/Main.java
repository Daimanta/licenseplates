package nl.leonvanderkaap.licenseplates;

import nl.leonvanderkaap.licenseplates.model.masterdata.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    @Autowired
    CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
