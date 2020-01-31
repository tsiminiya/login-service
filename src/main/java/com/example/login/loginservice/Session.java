package com.example.login.loginservice;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Session {

    @Id
    private Long id;

    private Long userId;

    private LocalDateTime createdAt;

    private Boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id) &&
                Objects.equals(userId, session.userId) &&
                Objects.equals(createdAt, session.createdAt) &&
                Objects.equals(active, session.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, createdAt, active);
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", userId=" + userId +
                ", createdAt=" + createdAt +
                ", active=" + active +
                '}';
    }
}
