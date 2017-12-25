package com.lanou.bookstore.category.domain;

import java.io.Serializable;

/**
 * Created by dllo on 17/9/26.
 */
public class Admin implements Serializable{
    private String adaminName;
    private String password;

    public Admin(String adaminName, String password) {
        this.adaminName = adaminName;
        this.password = password;
    }

    public Admin() {
    }

    public String getAdaminName() {
        return adaminName;
    }

    public void setAdaminName(String adaminName) {
        this.adaminName = adaminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
