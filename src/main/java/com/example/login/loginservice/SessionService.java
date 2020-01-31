package com.example.login.loginservice;

import org.slf4j.Logger;

import javax.annotation.PostConstruct;

public class SessionService {

    private final SessionIdGenerator sessionIdGenerator;
    private final Logger logger;

    public SessionService(SessionIdGenerator sessionIdGenerator, Logger logger) {
        this.sessionIdGenerator = sessionIdGenerator;
        this.logger = logger;
    }

    @PostConstruct
    public void initialize() {
        logger.info("Session Service has been initialized");
    }

    public String generateSessionId() {
        return sessionIdGenerator.generateSessionId();
    }

}

