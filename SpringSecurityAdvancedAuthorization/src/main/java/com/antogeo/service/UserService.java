package com.antogeo.service;

import com.antogeo.dao.UserDao;
import com.antogeo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userService")
@EnableTransactionManagement
public class UserService extends AbstractService {

    @Autowired
    private UserDao userDao;

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


    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {

        return userDao.getUserByUsername(username);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
