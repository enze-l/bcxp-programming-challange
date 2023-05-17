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
            throwExceptionBecauseOfParameterMisuse();
        }

        String calculatorMode = args[0];
        String filePath = args[1];

        switch (calculatorMode){
            case "weather":
                printDayWithMinTemperatureSpread(filePath);
                break;
            case "country":
                printCountryWithHighestPopulationDensity(filePath);
                break;
            default:
                throwExceptionBecauseOfParameterMisuse();
        }
    }

    private static void throwExceptionBecauseOfParameterMisuse(){
        String errorMessage =
                "Please provide Arguments for the mode of operation and the path to the .csv as follows: \n" +
                        " <mode> <file-path> \n" +
                        "possible modes are 'weather' and 'country'";
        throw new IllegalArgumentException(errorMessage);
    }

    private static void printCountryWithHighestPopulationDensity(String filePath) throws DataSourceException {
        String countryName = getCountryWithHighestPopulationDensityFromCSV(filePath);
        System.out.print(countryName);
    }

    private static String getCountryWithHighestPopulationDensityFromCSV(String filePath) throws DataSourceException {
        DataSource<CountryDetailItem> countryItemSource = new CSVFileReader<>(CountryDetailItem.class, filePath, ';');
        List<CountryDetailItem> countryItemList = countryItemSource.getItemList();
        ToIntFunction<CountryDetailItem> listSortFunction = CountryDetailItem::getPopulationDensity;
        CountryDetailItem countryMaxPopulationDensity = ItemListSorter.getMaxItem(countryItemList, listSortFunction);
        return countryMaxPopulationDensity.getCountryName();
    }

    private static void printDayWithMinTemperatureSpread(String filePath) throws DataSourceException {
        int dayNumber = getDayNumberWithMinTemperatureSpreadFromCSV(filePath);
        System.out.print(dayNumber);
    }

    public static int getDayNumberWithMinTemperatureSpreadFromCSV(String filePath) throws DataSourceException {
        DataSource<DayWeatherItem> dayItemSource = new CSVFileReader<>(DayWeatherItem.class, filePath, ',');
        List<DayWeatherItem> dayWeatherItemList = dayItemSource.getItemList();
        ToIntFunction<DayWeatherItem> listSortFunction = DayWeatherItem::getTemperatureSpread;
        DayWeatherItem dayWithSmallestTempSpread = ItemListSorter.getMinItem(dayWeatherItemList, listSortFunction);
        return dayWithSmallestTempSpread.getDayNumber();
    }
}
