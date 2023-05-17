package de.bcxp.challenge.DataProcessor;

import de.bcxp.challenge.DataItem.DayWeatherItem;

import java.util.Comparator;
import java.util.List;

public class WeatherProcessor extends AbstractDataProcessor {
    public static DayWeatherItem getDayWithMinTempSpread(List<DayWeatherItem> days) {
        checkListFilled(days);
        days.sort(Comparator.comparingInt(DayWeatherItem::getTemperatureSpread));
        return days.get(0);
    }
}
