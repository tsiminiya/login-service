package com.example.login.loginservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {

    Optional<Session> findByUserIdAndActive(Long userId, Boolean active);

}
