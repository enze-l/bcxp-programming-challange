package de.bcxp.challenge.DataProcessor;

import de.bcxp.challenge.DataItem.DayWeatherItem;

import java.util.Comparator;
import java.util.List;

public class TemperaturProcessor {
    public static DayWeatherItem getDayWithMinTempSpread(List<DayWeatherItem> days) {
        if (days.isEmpty()){
            throw new IllegalArgumentException("File does not contain required weather items");
        }
        days.sort(Comparator.comparingInt(DayWeatherItem::getTemperatureSpread));
        return days.get(0);
    }
}
