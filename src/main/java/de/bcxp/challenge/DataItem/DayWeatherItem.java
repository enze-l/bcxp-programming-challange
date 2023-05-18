package de.bcxp.challenge.DataItem;

import com.opencsv.bean.CsvBindByName;

public class DayWeatherItem implements ListItem {

    @CsvBindByName(column = "Day", required = true)
    private int dayNumber;

    @CsvBindByName(column = "MxT", required = true)
    private int maximumTemperatureFahrenheit;

    @CsvBindByName(column = "MnT", required = true)
    private int minimumTemperatureFahrenheit;

    public DayWeatherItem() {}
    public DayWeatherItem(int dayNumber, int minimumTemperatureFahrenheit, int maximumTemperatureFahrenheit) {
        this.dayNumber = dayNumber;
        this.maximumTemperatureFahrenheit = maximumTemperatureFahrenheit;
        this.minimumTemperatureFahrenheit = minimumTemperatureFahrenheit;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public int getTemperatureSpread() {
        return maximumTemperatureFahrenheit - minimumTemperatureFahrenheit;
    }
}
