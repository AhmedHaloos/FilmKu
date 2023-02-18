package com.eng.ashm.topmovies.data;

/**
 * this interface has created to notify the repositories that the data loaded from the backend
 * to the datasource is available.
 * it has only one method update
 */
public interface DataSourceListener<T> {
    /**
     * update the listeners for the data with the latest data loaded
     * @param t data loaded and provided to the listeners
     */
    public  void update(T t);
}
