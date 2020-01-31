package com.example.login.loginservice;

import com.example.login.loginservice.SessionIdGenerator;
import com.example.login.loginservice.SessionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;

public class SessionServiceTest {

    private Logger logger = Mockito.mock(Logger.class);
    private SessionIdGenerator sessionIdGenerator = Mockito.mock(SessionIdGenerator.class);

    private SessionService sessionService;

    @Before
    public void initialize() {
        sessionService = new SessionService(sessionIdGenerator, logger);
    }

    @Test
    public void testShouldReturnSessionId() {
        Mockito.when(sessionIdGenerator.generateSessionId()).thenReturn("1234-12345678-1234");

        sessionService = new SessionService(sessionIdGenerator, logger);
        String result = sessionService.generateSessionId();
        Assert.assertEquals("1234-12345678-1234", result);
    }

}
