package com.laundry.laundry.dao.persistentInterfaces;


import java.util.List;
import java.util.Optional;

/**
 *
 * @param <T> The class type this interface is being implemented in
 */
public interface LaundryPersistentUnit <T> {
    /**
     *
     * @param t object type to be persisted to the database
     * @return the object being persisted to the database
     */
    public T add(T t);

    /**
     *
     * @param id integer value denoting the unique identification of the record in the table in the database
     * @return the complete row associated with the id entered
     */
    public Optional<T>findById(long id);

    /**
     *
     * @param columnName name of column you want to filter your search by, e.g., name, age, DoB
     *      * @param value String value of the actual information you want to filter for
     *      * @param resultMax The maximum number of result you want to retrieve from the database. set to zero (0) to return all results found
     *      * @return returns a single record from the table
     */
    public Optional<T>findBy(String columnName, String value);

    /**
     *
     * @param columnName name of column you want to filter your search by, e.g., name, age, DoB
     * @param value String value of the actual information you want to filter for
     * @param resultMax The maximum number of result you want to retrieve from the database. set to zero (0) to return all results found
     * @return returns a list of object of the Class
     */
    public Optional<List<T>> findBy(String columnName, String value, int resultMax);
    /**
     *
     * @param columnName name of column you want to filter your search by, e.g., name, age, DoB
     * @param value Long value of the actual information you want to filter for
     * @param resultMax The maximum number of result you want to retrieve from the database. set to zero (0) to return all results found
     * @return returns a list of object of the Class
     */
    public Optional<List<T>>findBy(String columnName, long value, int resultMax);
    /**
     *
     * @param columnName name of column you want to filter your search by, e.g., name, age, DoB
     * @param value Integer value of the actual information you want to filter for
     * @param resultMax The maximum number of result you want to retrieve from the database. set to zero (0) to return all results found
     * @return returns a list of object of the Class
     */
    public Optional<List<T>>findBy(String columnName, int value, int resultMax);
    /**
     *
     * @param columnName name of column you want to filter your search by, e.g., name, age, DoB
     * @param value Object value of the actual information you want to filter for
     * @param resultMax The maximum number of result you want to retrieve from the database. set to zero (0) to return all results found
     * @return returns a list of object of the Class
     */
    public Optional<List<T>>findBy(String columnName, Object value, int resultMax);

    /**
     *
     * @param t populated object to be updated
     * @return object of class Type
     */
    public T update(T t);

}
