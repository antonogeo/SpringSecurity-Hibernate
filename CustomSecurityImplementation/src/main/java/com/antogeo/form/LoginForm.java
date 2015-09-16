package com.antogeo.form;


import org.hibernate.validator.constraints.*;

public class LoginForm {

    @NotEmpty(message = "Username is required - Hibernate Validator")
    @Length(min = 5 , max = 15, message = "The username must be between 5 and 15 characters")
    private String username;

    @NotEmpty(message = "Password is required - Hibernate Validator")
    private String password;


    public LoginForm() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
