package de.bcxp.challenge.DataItem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayWeatherItemTest {
    @Test
    void calculateTemperatureSpreadSuccessfully(){
        int dayNumber = 1;
        int minTemperature = 10;
        int maxTemperature = 15;
        DayWeatherItem dayWeatherItem = new DayWeatherItem(dayNumber, minTemperature, maxTemperature);

        int expectedTemperatureSpread = 5;

        assertEquals(expectedTemperatureSpread, dayWeatherItem.getTemperatureSpread());
    }
}
