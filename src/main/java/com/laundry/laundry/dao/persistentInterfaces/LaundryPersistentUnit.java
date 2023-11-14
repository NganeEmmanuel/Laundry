package com.laundry.laundry.dao.persistentInterfaces;


import java.util.Optional;

public interface LaundryPersistentUnit <T> {
    public T add(T t);
    public Optional<T>findById(long id);
    public Optional<T>findBy(String tableField, String value);
    public Optional<T>findBy(String tableField, long value);
    public Optional<T>findBy(String tableField, int value);
    public Optional<T>findBy(String tableField, Object value);

}
