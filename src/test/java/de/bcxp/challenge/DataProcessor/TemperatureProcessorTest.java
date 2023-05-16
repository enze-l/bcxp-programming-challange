package de.bcxp.challenge.DataProcessor;

import de.bcxp.challenge.DataItem.DayWeatherItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TemperatureProcessorTest {
    @Test
    void getDayWithMinTemperatureSpreadSuccessfully(){
        DayWeatherItem dayWithMediumSpread = new DayWeatherItem(1, 50, 70);
        DayWeatherItem dayWithLowestSpread = new DayWeatherItem(2, 55, 65);
        DayWeatherItem dayWithHighestSpread = new DayWeatherItem(3, 40, 80);

        List<DayWeatherItem> days = new ArrayList<>();

        days.add(dayWithMediumSpread);
        days.add(dayWithLowestSpread);
        days.add(dayWithHighestSpread);

        DayWeatherItem resultingDay = TemperaturProcessor.getDayWithMinTempSpread(days);

        assertEquals(dayWithLowestSpread, resultingDay);
    }

    @Test
    void getDayWithMinTemperatureSpreadFailsBecauseListIsEmpty(){
        List<DayWeatherItem> days = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () -> {
            TemperaturProcessor.getDayWithMinTempSpread(days);
        });
    }
}
