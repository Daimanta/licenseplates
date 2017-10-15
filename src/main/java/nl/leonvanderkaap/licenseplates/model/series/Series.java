package nl.leonvanderkaap.licenseplates.model.series;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nl.leonvanderkaap.licenseplates.model.masterdata.Country;
import org.springframework.stereotype.Service;

import javax.persistence.*;

import static java.util.regex.Pattern.compile;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @ManyToOne(optional = false)
    private Country country;
    @Setter
    private String name;
    @Setter
    private String strippedRegex;
    @Setter
    private String fullRegex;

    public Series(Country country, String name, String strippedRegex, String fullRegex) {
        this.country = country;
        this.name = name;
        if (!isRegex(strippedRegex)) {
            throw new IllegalArgumentException("Stripped regex is not a regex");
        }
        if (!isRegex(fullRegex)) {
            throw new IllegalArgumentException("Full regex is not a regex");
        }
        this.strippedRegex = strippedRegex;
        this.fullRegex = fullRegex;
    }

    public boolean stringMatchesSeries(String licencePlate) {
        return licencePlate.matches(strippedRegex) || licencePlate.matches(fullRegex);
    }

    public static boolean isRegex(final String str) {
        try {
            compile(str);
            return true;
        } catch (java.util.regex.PatternSyntaxException e) {
            return false;
        }
    }

}
