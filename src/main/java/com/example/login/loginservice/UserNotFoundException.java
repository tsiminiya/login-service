package com.example.login.loginservice;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {
        super("User " + username + " not found");
    }

}
