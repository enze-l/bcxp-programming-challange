package de.bcxp.challenge.DataSource;

import de.bcxp.challenge.DataItem.ListItem;

import java.util.List;

public interface DataSource<T extends ListItem> {
    public List<T> getItemList() throws DataSourceException;
}
