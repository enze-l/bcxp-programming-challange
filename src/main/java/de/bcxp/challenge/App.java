package de.bcxp.challenge;

import de.bcxp.challenge.DataItem.CountryDetailItem;
import de.bcxp.challenge.DataItem.DayWeatherItem;
import de.bcxp.challenge.DataItem.ItemListSorter;
import de.bcxp.challenge.DataSource.CSVFileReader;
import de.bcxp.challenge.DataSource.DataSource;
import de.bcxp.challenge.DataSource.DataSourceException;

import java.util.List;
import java.util.function.ToIntFunction;

public final class App {
    public static void main(String... args) throws DataSourceException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Please provide one argument for the path to the .csv file");
        }

        String calculatorMode = args [0];
        String filePath = args[1];

        switch (calculatorMode){
            case "weather":
                printDayWithMinTemperatureSpread(filePath);
                break;
            case "countries":
                printCountryWithHighestPopulationDensity(filePath);
        }
    }

    private static void printCountryWithHighestPopulationDensity(String filePath) throws DataSourceException {
        String countryName = getCountryWithHighestPopulationDensityFromCSV(filePath);
        System.out.print(countryName);
    }

    private static String getCountryWithHighestPopulationDensityFromCSV(String filePath) throws DataSourceException {
        DataSource<CountryDetailItem> countryItemSource = new CSVFileReader<>(CountryDetailItem.class, filePath, ';');
        List<CountryDetailItem> countryItemList = countryItemSource.getItemList();
        ToIntFunction<CountryDetailItem> sortFunction = CountryDetailItem::getPopulationDensity;
        CountryDetailItem countryMaxPopulationDensity = ItemListSorter.getMaxItem(countryItemList, sortFunction);
        return countryMaxPopulationDensity.getCountryName();
    }

    private static void printDayWithMinTemperatureSpread(String filePath) throws DataSourceException {
        int dayNumber = getDayNumberWithMinTemperatureSpreadFromCSV(filePath);
        System.out.print(dayNumber);
    }

    public static int getDayNumberWithMinTemperatureSpreadFromCSV(String filePath) throws DataSourceException {
        DataSource<DayWeatherItem> dayItemSource = new CSVFileReader<>(DayWeatherItem.class, filePath, ',');
        List<DayWeatherItem> dayWeatherItemList = dayItemSource.getItemList();
        ToIntFunction<DayWeatherItem> sortFunction = DayWeatherItem::getTemperatureSpread;
        DayWeatherItem dayWithSmallestTempSpread = ItemListSorter.getMinItem(dayWeatherItemList, sortFunction);
        return dayWithSmallestTempSpread.getDayNumber();
    }
}
