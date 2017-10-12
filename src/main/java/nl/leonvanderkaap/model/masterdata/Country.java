package nl.leonvanderkaap.model.masterdata;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {

    @Id
    String countryCode;
}
