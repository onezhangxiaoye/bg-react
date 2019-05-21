package com.react.entity;

public class Url {
   private int id;             //  id
   private String to;          // 指向的连接地址',
   private String name;        //  标签名称',
   private int tagFatherId; //  '父标签id',
   private int number;    //     '备用字段',
   private int hidden;    //     '备用字段',
   private String reserve1;    //  '备用字段',
   private String reserve2;    //  '备用字段',

    public Url() {
    }

    public Url(int id, String to, String name, int tagFatherId, int number, int hidden) {
        this.id = id;
        this.to = to;
        this.name = name;
        this.tagFatherId = tagFatherId;
        this.number = number;
        this.hidden = hidden;
    }

    public Url(String to, String name, int tagFatherId, int number, int hidden) {
        this.to = to;
        this.name = name;
        this.tagFatherId = tagFatherId;
        this.number = number;
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", to='" + to + '\'' +
                ", name='" + name + '\'' +
                ", tagFatherId=" + tagFatherId +
                ", number=" + number +
                ", hidden=" + hidden +
                ", reserve1='" + reserve1 + '\'' +
                ", reserve2='" + reserve2 + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTagFatherId() {
        return tagFatherId;
    }

    public void setTagFatherId(int tagFatherId) {
        this.tagFatherId = tagFatherId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getHidden() {
        return hidden;
    }

    public void setHidden(int hidden) {
        this.hidden = hidden;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }
}