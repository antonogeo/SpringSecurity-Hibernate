package com.antogeo.util.security;


public class SecurityUtil {

    public static String BCryptHash(String password){

        String encryptedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));

        return encryptedPassword;
    }

}
