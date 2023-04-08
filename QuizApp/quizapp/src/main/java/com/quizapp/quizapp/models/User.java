package com.quizapp.quizapp.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.apache.commons.codec.digest.DigestUtils;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long UID;

    private String username;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String encodedPwd;

    
    User(String username, String password){
        this.username = username;
        this.encodedPwd = DigestUtils.sha256Hex(password);
    }

    public boolean verify(String pwd){
        return encodedPwd == DigestUtils.sha256Hex(pwd);
    }
}
