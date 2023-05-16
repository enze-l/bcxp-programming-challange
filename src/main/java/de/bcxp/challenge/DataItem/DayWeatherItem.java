package de.bcxp.challenge.DataItem;

import com.opencsv.bean.CsvBindByName;

public class DayWeatherItem implements ListItem {

    @CsvBindByName(column = "Day")
    private int dayNumber;

    @CsvBindByName(column = "MxT")
    private int maximumTemperatureFahrenheit;

    @CsvBindByName(column = "MnT")
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

    public int getMaximumTemperatureFahrenheit() {
        return maximumTemperatureFahrenheit;
    }

    public int getMinimumTemperatureFahrenheit() {
        return minimumTemperatureFahrenheit;
    }

    public int getTemperatureSpread() {
        return maximumTemperatureFahrenheit - minimumTemperatureFahrenheit;
    }
}
