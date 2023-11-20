package com.laundry.laundry.dao.persistentInterfaces.persistentUnit;


import org.hibernate.query.Query;

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
     * @param value String value of the actual information you want to filter for
     * @return returns a single record from the table
     */
    public T findBy(String columnName, String value);

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

    /**
     *
     * @param t the object to be deleted from the database
     * @return returns the object that has been deleted
     *
     *@apiNote this function does not remove the row in the database table but rather changes the status so that it is marked as deleted. to completely remove the row, please use the remove() function
     */
    public T delete(T t);

    /**
     *
     * @param t the object to be deleted from the database
     * @return returns the object that has been deleted
     * @apiNote completely remove the row of from the database
     */
    public T remove(T t);

    /**
     *
     * @param query query to  be executed e.g., ("select u from users u where u.id = 1")
     * @return  a list of objects of the class type
     */
    public Optional<List<T>> runQuery(String query);

    /**
     *
     * @param query query to  be executed e.g., ("select u from users u where u.id = 1")
     * @return a single objects of the class type
     */
    public T runQuerySingle(String query);
    public void close();

}
