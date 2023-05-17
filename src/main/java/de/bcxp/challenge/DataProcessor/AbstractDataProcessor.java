package de.bcxp.challenge.DataProcessor;

import java.util.List;

public abstract class AbstractDataProcessor {
    public static void checkListFilled(List<?> list){
        if (list.isEmpty()){
            throw new IllegalArgumentException("File does not contain required weather items");
        }
    }
}
