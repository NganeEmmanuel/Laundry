package com.laundry.laundry.dao.persistentDao;

import com.laundry.laundry.dao.persistentInterfaces.entityPersist.ServicePersist;
import com.laundry.laundry.dao.persistentinit.LaundryPersistentDao;
import com.laundry.laundry.helper.helper.Merger;
import com.laundry.laundry.helper.status.ServiceStatus;
import com.laundry.laundry.model.Employee;
import com.laundry.laundry.model.Service;
import com.laundry.laundry.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class ServiceDao implements ServicePersist {
    private final EntityManager entityManager;
    private final LaundryPersistentDao laundryPersistentDao;
    public ServiceDao(){
        laundryPersistentDao = new LaundryPersistentDao();
        entityManager = laundryPersistentDao.getEntityManager();
    }
    @Override
    public Service add(Service service) {
        entityManager.getTransaction().begin();
        entityManager.persist(service);
        entityManager.getTransaction().commit();
        return service;
    }

    @Override
    public Optional<Service> findById(long id) {
        entityManager.getTransaction().begin();
        return Optional.ofNullable(entityManager.find(Service.class, id));
    }

    @Override
    public Service findBy(String columnName, String value) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT s FROM service s WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        try {
            return (Service) query.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    @Override
    public Optional<List<Service>> findBy(String columnName, String value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT s FROM service s WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0 ) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Service>> findBy(String columnName, long value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT s FROM service s WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0 ) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Service>> findBy(String columnName, int value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT s FROM service s WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0 ) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Service>> findBy(String columnName, Object value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT s FROM service s WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0 ) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Service update(Service service) {
        entityManager.getTransaction().begin();
        Optional<Service> serviceToUpdate = findById(service.getId());
        serviceToUpdate.ifPresent(value -> Merger.merge(value, service));
        entityManager.getTransaction().commit();
        return serviceToUpdate.orElse(null);
    }

    @Override
    public Service delete(Service service) {
        entityManager.getTransaction().begin();
        Optional<Service> serviceToDelete = findById(service.getId());
        serviceToDelete.ifPresent(value -> value.setServiceStatus(ServiceStatus.DELETED));
        entityManager.getTransaction().commit();
        return serviceToDelete.orElse(null);
    }

    @Override
    public Service remove(Service service) {
        entityManager.getTransaction().begin();
        entityManager.remove(service);
        entityManager.getTransaction().commit();
        return service;
    }

    @Override
    public Optional<List<Service>> runQuery(String query) {
        entityManager.getTransaction().begin();
        Query query1 = entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(query1.getResultList());
    }

    @Override
    public Service runQuerySingle(String query) {
        entityManager.getTransaction().begin();
        Query query1 =  entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        try {
            return (Service) query1.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    @Override
    public void close() {
        laundryPersistentDao.close();
    }
}
