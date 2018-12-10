package com.react.entity;

public class User {
    private Integer id;

    private String name;

    private String password;

    private String group_id;

    private String pic_name;

    public User(Integer id, String name, String password, String group_id, String pic_name) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.group_id = group_id;
        this.pic_name = pic_name;
    }

    public User() {
        super();
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
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id == null ? null : group_id.trim();
    }

    public String getPic_name() {
        return pic_name;
    }

    public void setPic_name(String pic_name) {
        this.pic_name = pic_name == null ? null : pic_name.trim();
    }
}