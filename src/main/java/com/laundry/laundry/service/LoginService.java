package com.laundry.laundry.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.laundry.laundry.dao.persistentDao.EmployeeDao;
import com.laundry.laundry.model.Employee;
import com.laundry.laundry.service.serviceInterface.UserManager;

import java.util.List;

public class LoginService implements UserManager<Employee> {
    private final EmployeeDao employeeDao = new EmployeeDao();

    @Override
    public Employee login(String username, String password) {
        String encryptedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        String query = "SELECT e FROM employee e WHERE name = " + username + " AND password = " + encryptedPassword;
        return (Employee) employeeDao.runQuery(query).orElse(null);
    }

    @Override
    public boolean isAuthorized(Employee employee) {
        return false;
    }

    @Override
    public boolean isAuthenticated(Employee employee) {
        return false;
    }
}
