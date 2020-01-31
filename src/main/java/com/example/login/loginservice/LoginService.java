package com.example.login.loginservice;

import java.util.Optional;

public class LoginService {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final TimeService timeService;

    public LoginService(UserRepository userRepository, SessionRepository sessionRepository, TimeService timeService) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
        this.timeService = timeService;
    }

    public Long login(String username, String password) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));

        if (!user.getPassword().equals(password)) {
            throw new InvalidAuthenticationException();
        }

        Session session = new Session();
        session.setUserId(user.getId());
        session.setCreatedAt(timeService.getCurrentTime());
        session.setActive(Boolean.TRUE);

        Session storedSession = sessionRepository.save(session);
        return storedSession.getId();
    }

    public void logout(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));

        Optional<Session> session = sessionRepository.findByUserIdAndActive(user.getId(), Boolean.TRUE);

        if (session.isPresent()) {
            Session storedSession = session.get();
            storedSession.setActive(Boolean.FALSE);
            sessionRepository.save(storedSession);
        }
    }

    public boolean isLoggedIn(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
        return sessionRepository.findByUserIdAndActive(user.getId(), Boolean.TRUE).isPresent();
    }

}
