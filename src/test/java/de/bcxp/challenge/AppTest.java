package de.bcxp.challenge;

import de.bcxp.challenge.DataSource.DataSourceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void getDayNumberWithMinTemperatureSpreadFromCSVSuccessfully() throws DataSourceException {
        String testFilePath = "src/test/resources/example_weather.csv";

        int resultingDayNumber = App.getDayNumberWithMinTemperatureSpreadFromCSV(testFilePath);
        int expectedDayNumber = 1;

        assertEquals(expectedDayNumber, resultingDayNumber);
    }

    @Test
    void getDayNumberWithMinTemperatureSpreadFromCSVFailsEmptyFile() throws DataSourceException {
        String testFilePath = "src/test/resources/empty_weather.csv";

        assertThrows(IllegalArgumentException.class, () -> App.getDayNumberWithMinTemperatureSpreadFromCSV(testFilePath));
    }

    @Test
    void getDayNumberWithMinTemperatureSpreadFromCSVFailsNoPathArg(){
        String invalidFilePath = "not/a/path/to/a/file.csv";

        assertThrows(DataSourceException.class, () -> App.getDayNumberWithMinTemperatureSpreadFromCSV(invalidFilePath));
    }
}
