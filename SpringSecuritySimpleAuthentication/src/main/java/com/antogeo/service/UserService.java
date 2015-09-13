package com.antogeo.service;

import com.antogeo.dao.UserDao;
import com.antogeo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {

        return userDao.getUserByUsername(username);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
