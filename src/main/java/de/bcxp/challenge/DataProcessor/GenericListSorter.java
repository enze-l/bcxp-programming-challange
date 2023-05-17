package de.bcxp.challenge.DataProcessor;

import de.bcxp.challenge.DataItem.ListItem;

import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class GenericListSorter extends AbstractDataProcessor{
    public static <T> T getMaxItem(List<T> list, ToIntFunction<? super T> sortFunction){
        checkListFilled(list);
        list.sort(Comparator.comparingInt(sortFunction));
        return list.get(0);
    }
}
