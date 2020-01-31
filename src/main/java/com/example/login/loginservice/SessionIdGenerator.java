package com.example.login.loginservice;

import java.util.UUID;

public class SessionIdGenerator {

    public String generateSessionId() {
        return UUID.randomUUID().toString();
    }

}
