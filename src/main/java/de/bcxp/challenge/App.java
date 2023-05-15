package de.bcxp.challenge;

import de.bcxp.challenge.DataItem.DayWeather;
import de.bcxp.challenge.DataProcessor.TemperaturProcessor;
import de.bcxp.challenge.DataSource.CSVFileReader;
import de.bcxp.challenge.DataSource.DataSource;
import de.bcxp.challenge.DataSource.DataSourceException;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) throws DataSourceException {

        String filePath = "src/main/resources/de/bcxp/challenge/weather.csv";
        DataSource<DayWeather> dataSource = new CSVFileReader<>(DayWeather.class, filePath);
        TemperaturProcessor temperaturProcessor = new TemperaturProcessor(dataSource);

        int dayWithSmallestTempSpread = temperaturProcessor.getDayWithMinTempSpread();     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = "Some country"; // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
