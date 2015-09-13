package com.antogeo.core.dao;

/**
 * Created by George on 26/10/2014.
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateUtil {

    @Autowired
    private SessionFactory sessionFactory;


    //Inserts

    protected Object insert(Object o)throws RuntimeException{ //TODO should I throw instead of catch?
        Session session =   getSessionFactory().getCurrentSession();
        session.save(o);
        return o;
    }

    //Updates

    protected Object update(Object o) throws RuntimeException{

        Session session = getSessionFactory().getCurrentSession();
        session.update(o);
        return o;
    }

    //Deletes

    protected boolean deleteById(Class<?> type, long id) throws RuntimeException{

        Session session = getSessionFactory().getCurrentSession();
        Object  persistentInstance = session.load(type, id);

        if(persistentInstance != null){
            session.delete(persistentInstance);
            return true;
        }
        return false;

    }

    //Selects

    protected List<Object> selectAll(String objectType){
        try{
            Session session = getSessionFactory().getCurrentSession();

            List<Object> objects = (List<Object>) session.createQuery("FROM " + objectType).list();
            return objects;
        }catch(RuntimeException e){
            getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw e;
        }
    }


    protected Object select(String objectType, String column, String value){
        try{

            String query = "FROM " + objectType + " A WHERE A." + column + " = :value ";

            Session session = getSessionFactory().getCurrentSession();
            List<Object> objects = session.createQuery(query).setParameter("value", value).list();

            //Todo change this
            if(objects.isEmpty()){
                System.out.println("No result with such value!");
                return null;
            }else if(objects.size() > 1){
                System.out.println("The list is bigger than 1! :( ");
                return null;
            }else {
                return objects.get(0);
            }
        }catch(RuntimeException e){
            getSessionFactory().getCurrentSession().getTransaction().rollback();
            System.out.println("Transaction rollback");
            throw e;
        }
    }


    protected Object selectList(String objectType, String column, String value){
        try{

            String query = "FROM " + objectType + " A WHERE A." + column + " = :value ";

            Session session = getSessionFactory().getCurrentSession();

            List<Object> objects = session.createQuery(query).setParameter("value", value).list();

            if(objects.isEmpty()){
                System.out.println("No result with such value!");
                return null;
            }else {
                return objects;
            }
        }catch(RuntimeException e){
            getSessionFactory().getCurrentSession().getTransaction().rollback();
            System.out.println("Transaction rollback");
            throw e;
        }
    }

    protected Object selectListById(String objectType, String column, long value){
        try{

            String query = "FROM " + objectType + " A WHERE A." + column + " = :value ";

            Session session = getSessionFactory().getCurrentSession();

            List<Object> objects = session.createQuery(query).setLong("value", value).list();

            if(objects.isEmpty()){
                System.out.println("No result with such value!");
                return null;
            }else {
                return objects;
            }
        }catch(RuntimeException e){
            getSessionFactory().getCurrentSession().getTransaction().rollback();
            System.out.println("Transaction rollback");
            throw e;
        }
    }

    protected Object selectById(String objectType, String column, long value){
        try{
            String query = "FROM " + objectType + " A WHERE A." + column + " = :value ";
            Session session = getSessionFactory().getCurrentSession();
            List<Object> objects = session.createQuery(query).setLong("value", value).list();
            return objects.get(0);
        }catch(RuntimeException e){
            getSessionFactory().getCurrentSession().getTransaction().rollback();
            System.out.println("Transaction rollback");
            throw e;
        }
    }

    protected Object selectManyToManyById(String objectType1, String objectType2, String column, long value){
        try{
            String query = "SELECT A FROM " + objectType1 + " A JOIN A." + objectType2 + " B WHERE B." + column + " = :value";
            Session session = getSessionFactory().getCurrentSession();
            List<Object> objects = session.createQuery(query).setLong("value", value).list();
            if(objects.isEmpty()){
                System.out.println("No result with such value!");
                return null;
            }else {
                return objects;
            }
        }catch(RuntimeException e){
            getSessionFactory().getCurrentSession().getTransaction().rollback();
            System.out.println("Transaction rollback");
            throw e;
        }
    }

    protected Object selectListByEntity(String objectType, String column, Object o){
        try{

            String query = "FROM " + objectType + " A WHERE A." + column + " = :value ";

            Session session = getSessionFactory().getCurrentSession();

            List<Object> objects = session.createQuery(query).setEntity("value",o).list();

            if(objects.isEmpty()){
                System.out.println("No result with such value!");
                return null;
            }else {
                return objects;
            }
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