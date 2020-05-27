package com.management.entity;

import java.util.Date;

public class PayRecord {
    private Integer id;
    private Integer ownerId;
    private String ownerUserName;
    //1 水费 2 电费 3 气费 4 物管费
    private Integer type;
    private Integer money;
    private Date date;

    @Override
    public String toString() {
        return "PayRecord{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", ownerUserName='" + ownerUserName + '\'' +
                ", type=" + type +
                ", money=" + money +
                ", date=" + date +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerUserName() {
        return ownerUserName;
    }

    public void setOwnerUserName(String ownerUserName) {
        this.ownerUserName = ownerUserName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
