package de.bcxp.challenge.DataItem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryDetailItemTest {
    @Test
    void calculateCountryDensitySuccessfully(){
        String countryName = "Testland";
        int populationNumber = 5000;
        int areaSquareKilometer = 1000;

        CountryDetailItem country = new CountryDetailItem(countryName, populationNumber, areaSquareKilometer);

        int expectedPopulationDensity = 5;

        assertEquals(expectedPopulationDensity, country.getPopulationDensity());
    }
}
