package com.laundry.laundry.service.serviceClass;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.laundry.laundry.dao.persistentDao.EmployeeDao;
import com.laundry.laundry.helper.session.sessionClass.EmployeeSession;
import com.laundry.laundry.model.Employee;
import com.laundry.laundry.service.serviceInterface.UserManager;



public class LoginService implements UserManager<Employee> {
    private final EmployeeDao employeeDao = new EmployeeDao();

    @Override
    public Employee login(String username, String password) {
        String encryptedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        System.out.println(encryptedPassword);
        String query = "SELECT e FROM Employee e WHERE username = '" + username + "'";
        Employee employee =  employeeDao.runQuerySingle(query);
        if(employee == null || !BCrypt.verifyer().verify(password.toCharArray(),
                employee.getPassword()).verified) return null;
        EmployeeSession.getInstace(employee);
        return employee;
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
