package com.management.entity;

import java.util.Date;

public class CarRequest {
    private Integer id;
    private String ownerUserName;
    private String ownerRealName;
    private String license;
    private String brand;
    private String color;
    private Date date;
    private Integer state;

    @Override
    public String toString() {
        return "CarRequest{" +
                "id=" + id +
                ", ownerUserName='" + ownerUserName + '\'' +
                ", ownerRealName='" + ownerRealName + '\'' +
                ", license='" + license + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", date=" + date +
                ", state=" + state +
                '}';
    }

    public String getOwnerRealName() {
        return ownerRealName;
    }

    public void setOwnerRealName(String ownerRealName) {
        this.ownerRealName = ownerRealName;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwnerUserName() {
        return ownerUserName;
    }

    public void setOwnerUserName(String ownerUserName) {
        this.ownerUserName = ownerUserName;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
