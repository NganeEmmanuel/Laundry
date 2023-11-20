package com.laundry.laundry.helper.session.sessionClass;

import com.laundry.laundry.helper.session.sessionInterface.UserSession;
import com.laundry.laundry.model.Employee;

public final class EmployeeSession implements UserSession<EmployeeSession, Employee> {
    private static EmployeeSession instance;
    private Employee employee;

    private EmployeeSession(Employee employee) {
        this.employee = employee;
    }

    public static EmployeeSession getInstace(Employee employee) {
        if(instance == null) {
            instance = new EmployeeSession(employee);
        }
        return instance;
    }
    public static EmployeeSession getInstace() {
        return instance;
    }

    public static boolean isSession(){
        return instance != null;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void cleanUserSession() {
        this.employee = null;
    }

    @Override
    public String toString() {
        return "EmployeeSession{" +
                "employee=" + employee +
                '}';
    }

}
