package nl.leonvanderkaap.licenseplates.model.masterdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter
public class Country {

    @Id
    private String countryCode;
}
