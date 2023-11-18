package com.laundry.laundry.dao.persistentDao;

import com.laundry.laundry.dao.persistentInterfaces.entityPersist.UserPersist;
import com.laundry.laundry.dao.persistentinit.LaundryPersistentDao;
import com.laundry.laundry.helper.Merger;
import com.laundry.laundry.helper.UserStatus;
import com.laundry.laundry.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class UserDao implements UserPersist {
    LaundryPersistentDao laundryPersistentDao;
    private final EntityManager entityManager;

    public UserDao() {
        laundryPersistentDao = new LaundryPersistentDao();
        this.entityManager = laundryPersistentDao.getEntityManager();
    }


    @Override
    public User add(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public Optional<User> findById(long id) {
        entityManager.getTransaction().begin();
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public Optional<User> findBy(String columnName, String value) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT u FROM users u WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        return (Optional<User>) query.getSingleResult();
    }

    @Override
    public Optional<List<User>> findBy(String columnName, String value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT u FROM users u WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<User>> findBy(String columnName, long value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT u FROM users u WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<User>> findBy(String columnName, int value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT u FROM users u WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<User>> findBy(String columnName, Object value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT u FROM users u WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public User update(User user) {
        entityManager.getTransaction().begin();
        Optional<User> userToUpdate = findById(user.getId());
        userToUpdate.ifPresent(value -> Merger.merge(value, user));
        entityManager.getTransaction().commit();
        return userToUpdate.orElse(null);
    }

    @Override
    public User delete(User user) {
        entityManager.getTransaction().begin();
        Optional<User> userToDelete = findById(user.getId());
        userToDelete.ifPresent(value -> value.setStatus(UserStatus.DELETED));
        entityManager.getTransaction().commit();
        return userToDelete.orElse(null);
    }

    @Override
    public User remove(User user) {
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public Optional<List<User>> runQuery(String query) {
        entityManager.getTransaction().begin();
        Query query1 = entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(query1.getResultList());
    }

    public void close(){
        laundryPersistentDao.close();
    }

}
