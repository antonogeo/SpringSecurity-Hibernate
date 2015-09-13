package com.antogeo.core.service;

import com.antogeo.core.dao.UserDao;
import com.antogeo.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by George on 26/10/2014.
 */
@Service("userService")
public class UserService extends AbstractService {

    @Autowired
    private UserDao userDao;


    @Transactional(readOnly = true)
    @Override
    public List<User> getAll() {

        return userDao.getAll();
    }

    @Transactional(readOnly = false)
    @Override
    public User insert(Object o) {

        return userDao.insert(o);
    }


    @Transactional(readOnly = false)
    @Override
    public User update(Object o) {

        return userDao.update(o);
    }


    @Transactional(readOnly = true)
    @Override
    public List<User> getObjectsByUserId(long userId) {

        return userDao.getObjectsByUserId(userId);
    }


    @Transactional(readOnly = true)
    @Override
    public User getObjectById(long objectId) {

        return userDao.getObjectById(objectId);
    }

    @Transactional(readOnly = false)
    @Override
    public boolean deleteObjectById(long objectId) {

        return userDao.deleteObjectById(objectId);
    }



    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {

        return userDao.getUserByUsername(username);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
