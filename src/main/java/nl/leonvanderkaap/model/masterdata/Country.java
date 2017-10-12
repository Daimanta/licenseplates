package nl.leonvanderkaap.model.masterdata;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @AllArgsConstructor @NoArgsConstructor
public class Country {

    @Id
    String countryCode;
}
