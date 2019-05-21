package com.react.entity;

public class User {
    private Integer id;
    private String name;
    private String password;
    private String picName;
    private String accessLevel;
    private String email;
    private String reserve3;

    public User() {
    }

    public User(Integer id, String name, String password, String picName, String accessLevel, String email, String reserve3) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.picName = picName;
        this.accessLevel = accessLevel;
        this.email = email;
        this.reserve3 = reserve3;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }
}