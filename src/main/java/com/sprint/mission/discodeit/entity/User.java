package com.sprint.mission.discodeit.entity;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    // 도메인 공통 필드
    final UUID id;
    final Long createdAt;
    Long updatedAt;

    // User 만의 필드
    String userName;
    String email;
    String password;

    public User(String userName, String email, String password){
        id = UUID.randomUUID();
        createdAt = System.currentTimeMillis();
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void update(String userName, String email, String password){
        this.userName = userName;
        this.email = email;
        this.password = password;
        updatedAt = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName +
                "', email='" + email +
                "', password='" + password +
                "'}";
    }
}
