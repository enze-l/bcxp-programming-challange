package de.bcxp.challenge.DataItem;

import com.opencsv.bean.CsvBindByName;

public class DayWeather implements Listable {

    @CsvBindByName(column = "Day")
    private int dayNumber;

    @CsvBindByName(column = "MxT")
    private int maximumTemperatureFahrenheit;

    @CsvBindByName(column = "MnT")
    private int minimumTemperatureFahrenheit;

    private int temperatureSpread;

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
        return temperatureSpread;
    }

    public void setTemperatureSpread(int temperatureSpread) {
        this.temperatureSpread = temperatureSpread;
    }
}
