package de.bcxp.challenge;

import de.bcxp.challenge.DataItem.DayWeatherItem;
import de.bcxp.challenge.DataProcessor.TemperaturProcessor;
import de.bcxp.challenge.DataSource.CSVFileReader;
import de.bcxp.challenge.DataSource.DataSource;
import de.bcxp.challenge.DataSource.DataSourceException;

/**
 * The entry class for the weather Application.
 */
public final class App {

    /**
     * This is the main entry method.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) throws DataSourceException {
        String filePath = args[0];

        DataSource<DayWeatherItem> dataSource = new CSVFileReader<>(DayWeatherItem.class, filePath);
        TemperaturProcessor temperaturProcessor = new TemperaturProcessor(dataSource);

        int dayWithSmallestTempSpread = temperaturProcessor.getDayWithMinTempSpread();
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);
    }
}
