package com.laundry.laundry.dao.persistentDao;

import com.laundry.laundry.dao.persistentInterfaces.entityPersist.OrderPersist;
import com.laundry.laundry.dao.persistentinit.LaundryPersistentDao;
import com.laundry.laundry.helper.Merger;
import com.laundry.laundry.helper.OrderStatus;
import com.laundry.laundry.model.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class OrderDao implements OrderPersist {
    private final EntityManager entityManager;
    private final LaundryPersistentDao laundryPersistentDao;
    public OrderDao(){
        laundryPersistentDao = new LaundryPersistentDao();
        entityManager = laundryPersistentDao.getEntityManager();
    }
    @Override
    public Order add(Order order) {
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        return order;
    }

    @Override
    public Optional<Order> findById(long id) {
        entityManager.getTransaction().begin();
        return Optional.ofNullable(entityManager.find(Order.class, id));
    }

    @Override
    public Optional<Order> findBy(String columnName, String value) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT o FROM orders o WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        return (Optional<Order>) query.getSingleResult();
    }

    @Override
    public Optional<List<Order>> findBy(String columnName, String value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT o FROM orders o WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0 ) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Order>> findBy(String columnName, long value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT o FROM orders o WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0 ) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Order>> findBy(String columnName, int value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT o FROM orders o WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0 ) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Optional<List<Order>> findBy(String columnName, Object value, int resultMax) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT o FROM orders o WHERE " + columnName + " = :value");
        query.setParameter("value", value);
        if(resultMax > 0 ) query.setMaxResults(resultMax);
        return Optional.ofNullable(query.getResultList());
    }

    @Override
    public Order update(Order order) {
        entityManager.getTransaction().begin();
        Optional<Order> orderToUpdate = findById(order.getId());
        orderToUpdate.ifPresent(value -> Merger.merge(value, order));
        entityManager.getTransaction().commit();
        return orderToUpdate.orElse(null);
    }

    @Override
    public Order delete(Order order) {
        entityManager.getTransaction().begin();
        Optional<Order> orderToDelete = findById(order.getId());
        orderToDelete.ifPresent(value -> value.setOrderStatus(OrderStatus.DELETED));
        entityManager.getTransaction().commit();
        return orderToDelete.orElse(null);
    }

    @Override
    public Order remove(Order order) {
        entityManager.getTransaction().begin();
        entityManager.remove(order);
        entityManager.getTransaction().commit();
        return order;
    }

    @Override
    public Optional<List<Order>> runQuery(String query) {
        entityManager.getTransaction().begin();
        Query query1 = entityManager.createQuery(query);
        entityManager.getTransaction().commit();
        return Optional.ofNullable(query1.getResultList());
    }

    @Override
    public void close() {
        laundryPersistentDao.close();
    }
}
