package com.antogeo.dao;

import com.antogeo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends AbstractDao  {

    private static final String TABLE = "User";
    private static final String USERNAME = "username";

    @Autowired
    private HibernateUtil hibernateUtil;

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Object insert(Object o) {
        return null;
    }

    @Override
    public List getByUserId(long userId) {
        return null;
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