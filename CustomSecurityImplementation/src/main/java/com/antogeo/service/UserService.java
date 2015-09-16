package com.antogeo.service;

import com.antogeo.dao.UserDao;
import com.antogeo.dto.UserDTO;
import com.antogeo.entity.User;
import com.antogeo.util.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


@Service("userService")
@EnableTransactionManagement
public class UserService {

    @Autowired
    private UserDao userDao;


    @Transactional(readOnly = true)
    public User getUserByUsername(String username) {

        return userDao.getUserByUsername(username);
    }

    @Transactional(readOnly = true)
    public UserDTO authenticateUser(String username, String password){
        User user = userDao.getUserByUsername(username);
        UserDTO userDTO = new UserDTO();

        if(user == null) {
            System.out.println("Username doesn't exist");
            userDTO.setExist(false);
            userDTO.setIsAuthenticated(false);
        }else if(!BCrypt.checkpw(password, user.getPassword())){
            System.out.println("Wrong password");
            userDTO.setExist(true);
            userDTO.setIsAuthenticated(false);
        }else{
            System.out.println("User exist & authenticated");
            userDTO.setExist(true);
            userDTO.setIsAuthenticated(true);
            userDTO.setUser(user);
        }
        return userDTO;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
