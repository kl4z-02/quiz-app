package com.quizapp.quizapp.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

import org.apache.commons.codec.digest.DigestUtils;

@Entity
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UID;
    private String username;
    private String password;

    public long getUID() {
        return UID;
    }
    public static class UserBuilder{
        public UserBuilder password(String password){
            this.password =  DigestUtils.sha256Hex(password);
            return this;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String pwd){
        password = DigestUtils.sha256Hex(pwd);
    }
    public boolean verify(String pwd){
        return password == DigestUtils.sha256Hex(pwd);
    }
}
