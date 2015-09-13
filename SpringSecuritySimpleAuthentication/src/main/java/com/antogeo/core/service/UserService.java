package com.antogeo.core.service;

import com.antogeo.core.dao.UserDao;
import com.antogeo.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
