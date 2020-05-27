package com.management.service.impl;

import com.management.entity.Account;
import com.management.mapper.AccountMapper;
import com.management.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountMapper accountMapper;


    @Override
    public int login(Account account) {
        Account accountByUsername = accountMapper.getAccountByUsername(account.getUserName());
        if(accountByUsername == null){
            //不存在
            return -1;
        }
        else if(accountByUsername.getPassWord().equals( account.getPassWord())){
            //存在且正确
            return 1;
        }
        else{
            //存在且不正确
            return 0;
        }
    }

}
