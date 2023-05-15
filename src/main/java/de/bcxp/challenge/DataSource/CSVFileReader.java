package de.bcxp.challenge.DataSource;

import com.opencsv.bean.CsvToBeanBuilder;
import de.bcxp.challenge.DataItem.Listable;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVFileReader<T extends Listable> implements DataSource<T>{

    private final Class<T> type;
    private final String path;

    public CSVFileReader(Class<T> type, String path){
        this.type = type;
        this.path = path;
    }

    public List<T> getItemList() throws DataSourceException {
        List<T> dataList;
        try (FileReader fileReader = new FileReader(this.path)){
            dataList = new CsvToBeanBuilder<T>(fileReader).withType(this.type).build().parse();
        } catch (IOException e) {
            throw new DataSourceException(e);
        }
        return dataList;
    }
}
