package nl.leonvanderkaap.licenceplates.model.series;

import nl.leonvanderkaap.licenseplates.model.masterdata.Country;
import nl.leonvanderkaap.licenseplates.model.series.Series;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SeriesTest {

    public Country netherlands;

    @Before
    public void setup() {
        netherlands = new Country("NLD");
    }

    @Test
    public void createSeries() {
        Series series = new Series(netherlands,"name",
                "(0-9){2}-(A-Z){2}-(0-9){2}",
                "(0-9){2}(A-Z){2}(0-9){2}");
    }

    @Test
    public void seriesMatchesString() {
        Series series = new Series(netherlands, "name",
                "[0-9]{2}-[A-Z]{2}-[0-9]{2}",
                "(0-9){2}(A-Z){2}(0-9){2}");
        Assert.assertTrue(series.stringMatchesSeries("12-AZ-31"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidRegexFails() {
        Series series = new Series(netherlands,"name",
                "([0-9]{2}-[A-Z]{2}-[0-9]{2}",
                "(0-9){2}(A-Z){2}(0-9){2}");
    }
}
