package de.bcxp.challenge.DataItem;

import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class ItemListSorter {
    public static <T> T getMaxIntItem(List<T> list, ToIntFunction<? super T> sortFunction){
        checkListFilledAndSort(list, sortFunction);
        return list.get(list.size() - 1);
    }

    public static <T> T getMinIntItem(List<T> list, ToIntFunction<? super T> sortFunction){
        checkListFilledAndSort(list, sortFunction);
        return list.get(0);
    }

    private static <T> void checkListFilledAndSort(List<T> list, ToIntFunction<? super T> sortFunction){
        if (list.isEmpty()){
            throw new IllegalArgumentException("File does not contain required weather items");
        }
        list.sort(Comparator.comparingInt(sortFunction));
    }
}
