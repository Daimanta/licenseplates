package nl.leonvanderkaap.licenseplates.model.series;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nl.leonvanderkaap.licenseplates.model.masterdata.Country;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor @Getter
public class SeriesDTO {

    private long id;
    private String country;
    private String name;
    private String strippedRegex;
    private String fullRegex;

    public SeriesDTO(Series series) {
        this.id = series.getId();
        this.name = series.getName();
        this.country = series.getCountry().getCountryCode();
        this.strippedRegex = series.getStrippedRegex();
        this.fullRegex = series.getFullRegex();
    }
}
