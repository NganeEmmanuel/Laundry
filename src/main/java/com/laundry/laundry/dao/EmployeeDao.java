package com.laundry.laundry.dao;

import com.laundry.laundry.dao.persistentInterfaces.EmployeePersist;
import com.laundry.laundry.dao.persistentinit.LaundryPersistentDao;
import com.laundry.laundry.helper.Merger;
import com.laundry.laundry.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class EmployeeDao implements EmployeePersist {
    private final EntityManager entityManager;
    LaundryPersistentDao laundryPersistentDao;

    public EmployeeDao() {
         laundryPersistentDao = new LaundryPersistentDao();
        this.entityManager = laundryPersistentDao.getEntityManager();
    }


    @Override
    public Employee add(Employee employee) {

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        return employee;
    }

    @Override
    public Optional<Employee> findById(long id) {
        return Optional.ofNullable(entityManager.find(Employee.class, id));
    }

    @Override
    public Optional<Employee> findBy(String columnName, String value) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT * FROM employee e WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        return (Optional<Employee>) query.getSingleResult();
    }

    public Optional<List<Employee>> findBy(String columnName, String value, int resultMax) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE " + columnName + " = :value" + ((resultMax > 0 )?" LIMIT " + resultMax:""));
        query.setParameter("value", value);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Employee>> findBy(String columnName, long value, int resultMax) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE " + columnName + " = :value" + ((resultMax > 0 )?" LIMIT " + resultMax:""));
        query.setParameter("value", value);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Employee>> findBy(String columnName, int value, int resultMax) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE " + columnName + " = :value" + ((resultMax > 0 )?" LIMIT " + resultMax:""));
        query.setParameter("value", value);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Employee>> findBy(String columnName, Object value, int resultMax) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE " + columnName + " = :value" + ((resultMax > 0 )?" LIMIT " + resultMax:""));
        query.setParameter("value", value);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Employee update(Employee employee) {
        entityManager.getTransaction().begin();
        Optional<Employee> employeeToUpdate = findById(employee.getId());
        employeeToUpdate.ifPresent(value -> Merger.merge(value, employee));
        entityManager.getTransaction().commit();
        return employeeToUpdate.get();
    }


}
