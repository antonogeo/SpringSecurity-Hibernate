package com.antogeo.validator;

import com.antogeo.form.LoginForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class LoginValidator implements Validator {

    @Override
    public boolean supports(Class aClass) {
        return LoginForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username error", "Username is required - Spring Validator");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password error", "Password is required - Spring Validator");

    }

}