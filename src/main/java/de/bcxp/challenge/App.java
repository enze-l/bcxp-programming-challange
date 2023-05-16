package de.bcxp.challenge;

import de.bcxp.challenge.DataItem.DayWeatherItem;
import de.bcxp.challenge.DataProcessor.TemperaturProcessor;
import de.bcxp.challenge.DataSource.CSVFileReader;
import de.bcxp.challenge.DataSource.DataSource;
import de.bcxp.challenge.DataSource.DataSourceException;

import java.util.List;

public final class App {
    public static void main(String... args) throws DataSourceException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Please provide one argument for the path to the .csv file");
        }
        String filePath = args[0];
        int dayNumber = getDayNumberWithMinTemperatureSpreadFromCSV(filePath);
        System.out.print(dayNumber);
    }

    public static int getDayNumberWithMinTemperatureSpreadFromCSV(String filePath) throws DataSourceException {
        DataSource<DayWeatherItem> dayItemSource = new CSVFileReader<>(DayWeatherItem.class, filePath);
        List<DayWeatherItem> dayWeatherItemList = dayItemSource.getItemList();
        DayWeatherItem dayWithSmallestTempSpread = TemperaturProcessor.getDayWithMinTempSpread(dayWeatherItemList);
        return dayWithSmallestTempSpread.getDayNumber();
    }
}
