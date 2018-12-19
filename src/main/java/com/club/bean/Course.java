package com.club.bean;

public class Course {
    //课程id
    private Integer id;
    //课程名
    private String name;
    //课程开课学期
    private String time;
    //课程时长+课时
    private Integer credit;
    //课程所属社团
    private String belong;
    //课程类别
    private String type;
    //课程开课地点
    private String place;
    //课程总招收人数
    private Integer amount;
    //课程简介
    private String detail;
    //课程已选人数
    private Integer selected;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", credit=" + credit +
                ", belong='" + belong + '\'' +
                ", type='" + type + '\'' +
                ", place='" + place + '\'' +
                ", amount=" + amount +
                ", detail='" + detail + '\'' +
                ", selected=" + selected +
                '}';
    }
}
