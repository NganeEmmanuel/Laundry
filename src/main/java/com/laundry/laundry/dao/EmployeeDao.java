package com.laundry.laundry.dao;

import com.laundry.laundry.dao.persistentInterfaces.EmployeePersist;
import com.laundry.laundry.dao.persistentinit.LaundryPersistentDao;
import com.laundry.laundry.model.Employee;

import java.util.Optional;

public class EmployeeDao implements EmployeePersist {

    private final LaundryPersistentDao laundryPersistentDao = new LaundryPersistentDao();


    @Override
    public Employee add(Employee employee) {

        laundryPersistentDao.getEntityManager().getTransaction().begin();
        laundryPersistentDao.getEntityManager().persist(employee);
        laundryPersistentDao.getEntityManager().getTransaction().commit();
        return employee;
    }

    @Override
    public Optional<Employee> findById(long id) {
        return Optional.ofNullable(laundryPersistentDao.getEntityManager().find(Employee.class, id));
    }

    @Override
    public Optional<Employee> findBy(String tableField, String value) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> findBy(String tableField, long value) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> findBy(String tableField, int value) {
        return Optional.empty();
    }

    @Override
    public Optional<Employee> findBy(String tableField, Object value) {
        return Optional.empty();
    }
}
