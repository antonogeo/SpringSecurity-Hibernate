package com.antogeo.service;

import com.antogeo.dao.UserDao;
import com.antogeo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userService")
public class UserService extends AbstractService {

    @Autowired
    private UserDao userDao;

    @Override
    public Object insert(Object o) {
        return null;
    }

    @Override
    public Object update(Object o) {
        return null;
    }

    @Override
    public List getObjectsByUserId(long userId) {
        return null;
    }

    @Override
    public boolean deleteObjectById(long objectId) {
        return false;
    }

    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {

        return userDao.getUserByUsername(username);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
