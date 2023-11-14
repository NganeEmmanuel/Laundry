package com.laundry.laundry.dao;

import com.laundry.laundry.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDao {
    private EntityManager entityManager;
    private EntityManagerFactory eMf;

    public UserDao() {
        this.eMf = Persistence.createEntityManagerFactory("laundry_pu");
        this.entityManager = this.eMf.createEntityManager();
    }

    public User addUser(User user){
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        return user;
    }

    public User findUser(long id){
        return entityManager.find(User.class, id);

    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManagerFactory geteMf() {
        return eMf;
    }

    public void seteMf(EntityManagerFactory eMf) {
        this.eMf = eMf;
    }

    public void close(){
        this.entityManager.close();
        this.eMf.close();
    }

//    public User updateUser(User user){
//        User userToUpdate = findUser(user.getId());
//
//        entityManager.getTransaction().begin();
//        userToUpdate.
//    }
}
