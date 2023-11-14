package com.laundry.laundry.dao.persistentinit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class LaundryPersistentDao{
    private EntityManager entityManager;
    private EntityManagerFactory eMf;

    public LaundryPersistentDao() {
        this.eMf = Persistence.createEntityManagerFactory("laundry_pu");
        this.entityManager = this.eMf.createEntityManager();
    }
    public LaundryPersistentDao(String persistentUnit){
        this.eMf = Persistence.createEntityManagerFactory(persistentUnit);
        this.entityManager = this.eMf.createEntityManager();
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

}
