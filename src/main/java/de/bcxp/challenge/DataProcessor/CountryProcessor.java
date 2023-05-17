package de.bcxp.challenge.DataProcessor;

import de.bcxp.challenge.DataItem.CountryDetailItem;

import java.util.Comparator;
import java.util.List;

public class CountryProcessor extends AbstractDataProcessor {
    public static CountryDetailItem getMaxPopulationDensityCountry(List<CountryDetailItem> countries){
        checkListFilled(countries);
        countries.sort(Comparator.comparingInt(CountryDetailItem::getPopulationDensity));
        return countries.get(countries.size() - 1);
    }
}
