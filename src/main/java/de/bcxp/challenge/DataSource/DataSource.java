package de.bcxp.challenge.DataSource;

import de.bcxp.challenge.DataItem.Listable;

import java.util.List;

public interface DataSource<T extends Listable> {
    public List<T> getObjectList() throws DataSourceException;
}
