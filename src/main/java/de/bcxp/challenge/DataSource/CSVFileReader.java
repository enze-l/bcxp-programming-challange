package de.bcxp.challenge.DataSource;

import com.opencsv.bean.CsvToBeanBuilder;
import de.bcxp.challenge.DataItem.ListItem;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVFileReader<T extends ListItem> implements DataSource<T>{

    private final Class<T> type;
    private final String path;
    private final char seperator;

    public CSVFileReader(Class<T> type, String path, char seperator){
        this.type = type;
        this.path = path;
        this.seperator = seperator;
    }

    public List<T> getItemList() throws DataSourceException {
        try (FileReader fileReader = new FileReader(this.path)){
            return new CsvToBeanBuilder<T>(fileReader).withType(this.type).withSeparator(seperator).build().parse();
        } catch (IOException e) {
            throw new DataSourceException(e);
        }
    }
}
