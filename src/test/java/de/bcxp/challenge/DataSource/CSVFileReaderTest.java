package de.bcxp.challenge.DataSource;

import de.bcxp.challenge.DataItem.DayWeatherItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class CSVFileReaderTest {
    @Test
    void readFileSuccessfully() throws DataSourceException {
        String validFilePath = "src/test/java/de/bcxp/challenge/DataSource/example_weather.csv";
        CSVFileReader<DayWeatherItem> csvFileReader = new CSVFileReader<>(DayWeatherItem.class, validFilePath);

        List<DayWeatherItem> days = csvFileReader.getItemList();

        int expectedDayNumber = 1;
        assertEquals(expectedDayNumber, days.get(0).getDayNumber());
    }

    @Test
    void readFileThrowsException() {
        assertThrows(DataSourceException.class, () -> {
            String invalidFilePath = "not/a/path/to/a/file.csv";
            CSVFileReader<DayWeatherItem> csvFileReader = new CSVFileReader<>(DayWeatherItem.class, invalidFilePath);

            List<DayWeatherItem> days = csvFileReader.getItemList();
        });
    }
}
