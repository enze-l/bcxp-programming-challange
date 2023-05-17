package de.bcxp.challenge.DataItem;

import com.opencsv.bean.CsvBindByName;

public class CountryDetailItem implements ListItem {
    @CsvBindByName(column = "Name")
    private String countryName;

    @CsvBindByName(column = "Population")
    private String populationNumberString;

    @CsvBindByName(column = "Area (km²)")
    private int areaSquareKilometer;

    public CountryDetailItem(){}

    public CountryDetailItem(String countryName, int populationNumber, int areaSquareKilometer) {
        this.countryName = countryName;
        this.populationNumberString = String.valueOf(populationNumber);
        this.areaSquareKilometer = areaSquareKilometer;
    }

    private int populationNumberStringToInt(){
        String clearedNumberString = this.populationNumberString.split(",")[0].replace(".", "");
        return Integer.parseInt(clearedNumberString);
    }

    public String getCountryName() {
        return countryName;
    }

    public int getPopulationDensity(){
        return this.populationNumberStringToInt() / areaSquareKilometer;
    }
}
