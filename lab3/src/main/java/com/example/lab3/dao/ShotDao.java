package com.example.lab3.dao;
import com.example.lab3.Shot;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Named("ShotDao")
public class ShotDao implements Serializable {
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    private EntityTransaction entityTransaction;

    public void createEntityManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("shots");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    public void addShotToDB(Shot shot) {
//        if (!entityTransaction.isActive()){
//            entityTransaction.begin();
//            entityManager.persist(shot);
//            entityTransaction.commit();
//        }
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(shot);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().commit();
    }

    public List<Shot> getShotsFromDB() {
        return entityManager.createQuery("select s from Shot s", Shot.class).getResultList();
    }

    public void clearShotsInBD() {
        entityManager.getTransaction().begin();
        try {
            entityManager.createQuery("delete from Shot").executeUpdate();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().commit();
    }
}

