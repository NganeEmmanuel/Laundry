package com.laundry.laundry.service.serviceClass;

import com.laundry.laundry.dao.persistentDao.EmployeeDao;
import com.laundry.laundry.model.Employee;

public class SignupService {
    private final EmployeeDao employeeDao = new EmployeeDao();

    /**
     *
     * @param employee the employee you want insert into the database
     * @return the employee data created in the database
     */
    public Employee createAccount(Employee employee){
        return employeeDao.add(employee);
    }

    /**
     *
     * @param username string that you want to filter by
     * @return employee object if present and null if absent
     */
    public Employee findByUsername(String username){
        return employeeDao.findBy("username", username);
    }

    /**
     *
     * @param email email address that you wish to filter by
     * @return employee object if present and null if absent
     */
    public Employee findByEmail(String email){
        return employeeDao.findBy("email", email);
    }
}
