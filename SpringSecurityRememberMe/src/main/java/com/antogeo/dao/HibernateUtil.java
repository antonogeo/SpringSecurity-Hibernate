package com.antogeo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateUtil {

    @Autowired
    private SessionFactory sessionFactory;


    protected Object select(String objectType, String column, String value){
        try{

            String query = "FROM " + objectType + " A WHERE A." + column + " = :value ";

            Session session = getSessionFactory().getCurrentSession();
            List<Object> objects = session.createQuery(query).setParameter("value", value).list();

            return objects.get(0);

        }catch(RuntimeException e){
            getSessionFactory().getCurrentSession().getTransaction().rollback();
            System.out.println("Transaction rollback");
            throw e;
        }
    }

    protected SessionFactory getSessionFactory() {

        return sessionFactory;
    }



}