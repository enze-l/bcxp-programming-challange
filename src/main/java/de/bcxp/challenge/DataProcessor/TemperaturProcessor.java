package de.bcxp.challenge.DataProcessor;

import de.bcxp.challenge.DataItem.DayWeatherItem;

import java.util.Comparator;
import java.util.List;

public class TemperaturProcessor {
    public static int getDayWithMinTempSpread(List<DayWeatherItem> days) {
        days.sort(Comparator.comparingInt(DayWeatherItem::getTemperatureSpread));
        return days.get(0).getDayNumber();
    }
}
