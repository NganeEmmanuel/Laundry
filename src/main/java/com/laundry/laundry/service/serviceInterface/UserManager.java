package com.laundry.laundry.service.serviceInterface;

public interface UserManager<T> {
    public T login(String username, String password);
    public boolean isAuthorized(T t);
    public boolean isAuthenticated(T t);
}
