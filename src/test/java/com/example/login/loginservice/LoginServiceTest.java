package com.example.login.loginservice;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

public class LoginServiceTest {

    private static final LocalDateTime NOW = LocalDateTime.parse("2020-01-31T00:00:00");

    private LoginService loginService;

    private UserRepository userRepository = Mockito.mock(UserRepository.class);
    private SessionRepository sessionRepository = Mockito.mock(SessionRepository.class);
    private TimeService timeService = Mockito.mock(TimeService.class);

    @Before
    public void setUp() {
        loginService = new LoginService(userRepository, sessionRepository, timeService);
    }

    @Test
    public void testUserShouldBeAbleToLogin() {
        Mockito.when(userRepository.findByUsername("romeo")).thenReturn(Optional.of(buildUser()));
        Mockito.when(timeService.getCurrentTime()).thenReturn(NOW);
        Mockito.when(sessionRepository.save(Mockito.any(Session.class))).thenReturn(buildStoredSession());

        loginService.login("romeo", "password");

        Mockito.verify(sessionRepository).save(buildNewSession());
    }

    private User buildUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("romeo");
        user.setPassword("password");
        return user;
    }

    private Session buildNewSession() {
        Session session = new Session();
        session.setUserId(1L);
        session.setActive(Boolean.TRUE);
        session.setCreatedAt(NOW);
        return session;
    }

    private Session buildStoredSession() {
        Session session = new Session();
        session.setId(1L);
        session.setUserId(1L);
        session.setActive(Boolean.TRUE);
        session.setCreatedAt(NOW);
        return session;
    }

}
