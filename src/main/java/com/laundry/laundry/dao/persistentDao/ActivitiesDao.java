package com.laundry.laundry.dao.persistentDao;

import com.laundry.laundry.dao.persistentInterfaces.entityPersist.ActivitiesPersist;
import com.laundry.laundry.dao.persistentinit.LaundryPersistentDao;
import com.laundry.laundry.helper.helper.Merger;
import com.laundry.laundry.model.Activities;
import com.laundry.laundry.model.Employee;
import com.laundry.laundry.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class ActivitiesDao implements ActivitiesPersist {
    private final LaundryPersistentDao laundryPersistentDao;
    private final EntityManager entityManager;

    public ActivitiesDao() {
        laundryPersistentDao = new LaundryPersistentDao();
        this.entityManager = laundryPersistentDao.getEntityManager();
    }

    @Override
    public Activities add(Activities activities) {
        entityManager.getTransaction().begin();
        entityManager.persist(activities);
        entityManager.getTransaction().commit();
        return activities;
    }

    @Override
    public Optional<Activities> findById(long id) {
        entityManager.getTransaction().begin();
        return Optional.ofNullable(entityManager.find(Activities.class, id));
    }

    @Override
    public Activities findBy(String columnName, String value) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Activities a where " + columnName + " = :value");
        query.setParameter("value", value);
        try {
            return (Activities) query.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    @Override
    public Optional<List<Activities>> findBy(String columnName, String value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Activities a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Activities>> findBy(String columnName, long value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Activities a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Activities>> findBy(String columnName, int value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Activities a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Activities>> findBy(String columnName, Object value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select a from Activities a where " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Activities update(Activities activities) {
        entityManager.getTransaction().begin();
        Optional<Activities> activitiesToUpdate = findById(activities.getId());
        activitiesToUpdate.ifPresent(value -> Merger.merge(value, activities));
        entityManager.getTransaction().commit();
        return activitiesToUpdate.orElse(null);
    }

    @Override
    public Activities delete(Activities activities) {
        return null;
    }

    @Override
    public Activities remove(Activities activities) {
        entityManager.getTransaction().begin();
        entityManager.remove(activities);
        entityManager.getTransaction().commit();
        return activities;
    }

    @Override
    public Optional<List<Activities>> runQuery(String query) {
        entityManager.getTransaction().begin();
        Query query1 = entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(query1.getResultList());
    }

    @Override
    public Activities runQuerySingle(String query) {
        entityManager.getTransaction().begin();
        Query query1 =  entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        try {
            return (Activities) query1.getSingleResult();
        }catch (NoResultException n){
            return null;
        }
    }

    @Override
    public void close() {
        laundryPersistentDao.close();
    }
}
