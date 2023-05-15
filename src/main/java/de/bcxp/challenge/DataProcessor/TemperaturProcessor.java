package de.bcxp.challenge.DataProcessor;

import de.bcxp.challenge.DataItem.DayWeatherItem;
import de.bcxp.challenge.DataSource.DataSource;
import de.bcxp.challenge.DataSource.DataSourceException;

import java.util.List;

public class TemperaturProcessor {
    private final DataSource<DayWeatherItem> dataSource;

    public TemperaturProcessor(DataSource<DayWeatherItem> dataSource){
        this.dataSource = dataSource;
    }

    public int getDayWithMinTempSpread() throws DataSourceException {
        List<DayWeatherItem> days = dataSource.getItemList();

        DayWeatherItem lowestTempSpreadDay = days.get(0);
        for (DayWeatherItem day : days){
            if (day.getTemperatureSpread() < lowestTempSpreadDay.getTemperatureSpread()){
                lowestTempSpreadDay = day;
            }
        }

        return lowestTempSpreadDay.getDayNumber();
    }
}
