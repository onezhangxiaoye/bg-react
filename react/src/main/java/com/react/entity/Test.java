package com.react.entity;

public class Test {
    private Integer id;

    private String name;

    private Integer dep;

    private Integer birthday;

    private String picName;

    public Test(Integer id, String name, Integer dep, Integer birthday, String picName) {
        this.id = id;
        this.name = name;
        this.dep = dep;
        this.birthday = birthday;
        this.picName = picName;
    }

    public Test() {
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

    public Integer getDep() {
        return dep;
    }

    public void setDep(Integer dep) {
        this.dep = dep;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName == null ? null : picName.trim();
    }
}