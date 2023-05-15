package de.bcxp.challenge.DataSource;

import com.opencsv.bean.CsvToBeanBuilder;
import de.bcxp.challenge.DataItem.Listable;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CSVFileReader<T extends Listable> implements DataSource<T>{

    private final Class<T> type;
    private final String path;

    public CSVFileReader(Class<T> type, String path){
        this.type = type;
        this.path = path;
    }

    public List<T> getObjectList() throws DataSourceException {
        List<T> dataList = null;
        try {
            dataList = new CsvToBeanBuilder<T>(new FileReader(this.path)).withType(this.type).build().parse();
        } catch (FileNotFoundException e) {
            throw new DataSourceException(e);
        }
        return dataList;
    }
}
