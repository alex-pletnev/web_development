package com.example.lab3.util;

import com.example.lab3.Shot;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class DBUtils {
    private static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Shot.class)
            .buildSessionFactory();

    public static void addElement(Shot shot) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(shot);
        session.getTransaction().commit();
    }

    public static List<Shot> getAllElements() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Shot> shots = session.createQuery("from Shot").getResultList();
        session.getTransaction().commit();
        return shots;
    }

    public static void deleteAllElements() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("delete Shot").executeUpdate();
        session.getTransaction().commit();
    }
}
