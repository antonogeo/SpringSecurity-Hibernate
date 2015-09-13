package com.antogeo.web.dto;

import com.antogeo.core.entity.User;

/**
 * Created by George on 19/11/2014.
 */
public class UserDTO {

    private User user;
    private Boolean exist;
    private Boolean isAuthenticated;




    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getExist() {
        return exist;
    }

    public void setExist(Boolean exist) {
        this.exist = exist;
    }

    public Boolean getIsAuthenticated() {
        return isAuthenticated;
    }

    public void setIsAuthenticated(Boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }
}
