package com.management.service;

import com.management.entity.Pay;

public interface PayService {
    public void addWater(Pay pay,int money);
    public void addElectric(Pay pay,int money);
    public void addGas(Pay pay,int money);
    public void addManage(Pay pay,int money);
}
