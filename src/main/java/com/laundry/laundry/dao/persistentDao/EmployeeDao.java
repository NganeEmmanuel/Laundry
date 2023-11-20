package com.laundry.laundry.dao.persistentDao;

import com.laundry.laundry.dao.persistentInterfaces.entityPersist.EmployeePersist;
import com.laundry.laundry.dao.persistentinit.LaundryPersistentDao;
import com.laundry.laundry.helper.helper.Merger;
import com.laundry.laundry.helper.status.UserStatus;
import com.laundry.laundry.model.Employee;
import com.laundry.laundry.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class EmployeeDao implements EmployeePersist {
    private final LaundryPersistentDao laundryPersistentDao;
    private final EntityManager entityManager;

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
    public Employee findBy(String columnName, String value) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT e FROM employee e WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        try {
            return (Employee) query.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    public Optional<List<Employee>> findBy(String columnName, String value, int resultMax) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Employee>> findBy(String columnName, long value, int resultMax) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE " + columnName + " = :value" + ((resultMax > 0 )?" LIMIT " + resultMax:""));
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Employee>> findBy(String columnName, int value, int resultMax) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Employee>> findBy(String columnName, Object value, int resultMax) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Employee update(Employee employee) {
        entityManager.getTransaction().begin();
        Optional<Employee> employeeToUpdate = findById(employee.getId());
        employeeToUpdate.ifPresent(value -> Merger.merge(value, employee));
        entityManager.getTransaction().commit();
        return employeeToUpdate.orElse(null);
    }

    @Override
    public Employee delete(Employee employee) {
        entityManager.getTransaction().begin();
        Optional<Employee> employeeToDelete =findById(employee.getId());
        employeeToDelete.ifPresent(value -> value.setStatus(UserStatus.DELETED));
        entityManager.getTransaction().commit();
        return employeeToDelete.orElse(null);
    }

    @Override
    public Employee remove(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
        return employee;
    }

    @Override
    public Optional<List<Employee>> runQuery(String query) {
        entityManager.getTransaction().begin();
        Query query1 =  entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(query1.getResultList());
    }

    @Override
    public Employee runQuerySingle(String query) {
        entityManager.getTransaction().begin();
        Query query1 =  entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        try {
            return (Employee) query1.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    @Override
    public void close() {
        laundryPersistentDao.close();
    }


}
