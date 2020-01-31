package com.example.login.loginservice;

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

        Session storedSession = sessionRepository.save(session);
        return storedSession.getId();
    }

}
