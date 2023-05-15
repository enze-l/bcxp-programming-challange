package de.bcxp.challenge;

import de.bcxp.challenge.DataSource.CSVFileReader;
import de.bcxp.challenge.DataSource.DataSourceException;
import de.bcxp.challenge.DataItem.DayWeather;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CSVFileReaderTest {
    @Test
    void readFile() throws DataSourceException {
        String filePath = "src/main/resources/de/bcxp/challenge/weather.csv";
        CSVFileReader<DayWeather> csvFileReader = new CSVFileReader<>(DayWeather.class, filePath);

        List<DayWeather> days = csvFileReader.getObjectList();

        for(DayWeather day : days){
            System.out.println(day.getDayNumber());
        }
    }
}
