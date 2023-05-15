package de.bcxp.challenge.DataProcessor;

import de.bcxp.challenge.DataItem.DayWeather;
import de.bcxp.challenge.DataSource.DataSource;
import de.bcxp.challenge.DataSource.DataSourceException;

import java.util.List;

public class TemperaturProcessor {
    private final DataSource<DayWeather> dataSource;

    public TemperaturProcessor(DataSource<DayWeather> dataSource){
        this.dataSource = dataSource;
    }

    public int getDayWithMinTempSpread() throws DataSourceException {
        List<DayWeather> days = dataSource.getItemList();

        DayWeather lowestTempSpreadDay = days.get(0);
        for (DayWeather day : days){
            if (day.getTemperatureSpread() < lowestTempSpreadDay.getTemperatureSpread()){
                lowestTempSpreadDay = day;
            }
        }

        return lowestTempSpreadDay.getDayNumber();
    }
}
