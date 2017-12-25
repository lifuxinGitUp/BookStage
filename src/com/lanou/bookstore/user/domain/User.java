package com.lanou.bookstore.user.domain;

import java.io.Serializable;

/**
 * Created by dllo on 17/9/21.
 */
public class User implements Serializable {
    private String uid;
    private String username;
    private String password;
    private String email;
    private String code;
    private String verifyCode;
    private boolean state;

    public User(String uid, String username, String password, String email, String code, String verifyCode, boolean state) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.code = code;
        this.verifyCode = verifyCode;
        this.state = state;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", code='" + code + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                ", state=" + state +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
