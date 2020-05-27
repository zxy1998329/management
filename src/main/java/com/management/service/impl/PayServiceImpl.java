package com.management.service.impl;

import com.management.entity.Pay;
import com.management.mapper.PayMapper;
import com.management.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    PayMapper payMapper;

    @Override
    public void addWater(Pay pay, int money) {
        int temp = pay.getWater();
        temp = temp + money;
        pay.setWater(temp);
        payMapper.updatePay(pay);
    }

    @Override
    public void addElectric(Pay pay, int money) {
        int temp = pay.getElectric();
        temp = temp + money;
        pay.setElectric(temp);
        payMapper.updatePay(pay);
    }

    @Override
    public void addGas(Pay pay, int money) {
        int temp = pay.getGas();
        temp=temp + money;
        pay.setGas(temp);
        payMapper.updatePay(pay);
    }

    @Override
    public void addManage(Pay pay, int money) {
        int temp = pay.getManage();
        temp = temp + money;
        pay.setManage(temp);
        payMapper.updatePay(pay);
    }
}
