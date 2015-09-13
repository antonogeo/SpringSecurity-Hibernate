package com.antogeo.dao;

import com.antogeo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {

    private static final String TABLE = "User";
    private static final String USERNAME = "username";

    @Autowired
    private HibernateUtil hibernateUtil;


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