package com.management.entity;

public class Pay {
    private Integer id;
    private Integer water;
    private Integer electric;
    private Integer gas;
    private Integer manage;

    @Override
    public String toString() {
        return "Pay{" +
                "id=" + id +
                ", water=" + water +
                ", electric=" + electric +
                ", gas=" + gas +
                ", manage=" + manage +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWater() {
        return water;
    }

    public void setWater(Integer water) {
        this.water = water;
    }

    public Integer getElectric() {
        return electric;
    }

    public void setElectric(Integer electric) {
        this.electric = electric;
    }

    public Integer getGas() {
        return gas;
    }

    public void setGas(Integer gas) {
        this.gas = gas;
    }

    public Integer getManage() {
        return manage;
    }

    public void setManage(Integer manage) {
        this.manage = manage;
    }
}
