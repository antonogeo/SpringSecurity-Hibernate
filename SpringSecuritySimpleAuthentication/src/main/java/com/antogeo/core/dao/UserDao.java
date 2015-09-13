package com.antogeo.core.dao;

import com.antogeo.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by George on 26/10/2014.
 */
@Repository
public class UserDao extends AbstractDao {

    private static final String TABLE = "User";
    private static final String USERNAME = "username";
    private static final String USER_ID = "userId";

    @Autowired
    private HibernateUtil hibernateUtil;


    @Override
    public List<User> getAll() {

        List<User> users = (List<User>)(List<?>)hibernateUtil.selectAll(TABLE);
        return (List<User>)(Object)users;
    }

    @Override
    public User insert(Object o) {

        return (User) hibernateUtil.insert(o);
    }

    @Override
    public User update(Object o) {

        return (User) hibernateUtil.update(o);
    }

    @Override
    public List<User> getObjectsByUserId(long userId) {
        return null;
    }

    @Override
    public User getObjectById(long objectId) {

        return (User) hibernateUtil.selectById(TABLE, USER_ID, objectId);
    }

    @Override
    public boolean deleteObjectById(long objectId) {
        return false;
    }



    public User getUserByUsername(String username) {

        return (User) hibernateUtil.select(TABLE, USERNAME, username);
    }


    public HibernateUtil getHibernateUtil() {

        return hibernateUtil;
    }

    public void setHibernateUtil(HibernateUtil hibernateUtil) {

        this.hibernateUtil = hibernateUtil;
    }
}