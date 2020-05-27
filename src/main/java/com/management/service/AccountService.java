package com.management.service;

import com.management.entity.Account;
import com.management.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public interface AccountService {

    //判断账号密码是否正确以及存在，不存在-1，密码错误0，正确1
    public int login(Account account);
}
