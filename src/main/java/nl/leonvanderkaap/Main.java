package nl.leonvanderkaap;

import nl.leonvanderkaap.model.masterdata.Country;
import nl.leonvanderkaap.model.masterdata.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Main {

    @Autowired
    CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner demo(CountryRepository repository) {
        return (args) -> {
            repository.save(new Country("NL"));
            List<Country> countries = repository.findAll();
            Optional<Country> ct = repository.findOne("NL");
            System.out.println(ct.isPresent());
            System.out.println(countries.size());
        };
    }
}
