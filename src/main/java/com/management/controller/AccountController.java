package com.management.controller;

import com.management.entity.Account;
import com.management.entity.Pay;
import com.management.mapper.AccountMapper;
import com.management.mapper.PayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AccountController {
    @Autowired
    AccountMapper accountMapper;

    @Autowired
    PayMapper payMapper;

    //账号展示页面
    @GetMapping("accounts")
    public String list(HttpSession session, Model model){
        List<Account> accounts = accountMapper.findAllUsers();
        model.addAttribute("accounts",accounts);
        return "account/list";
    }

    //来到账号添加页面
    @GetMapping("account")
    public String toAddPage(){
        return "account/add";
    }

    //账号添加请求
    @PostMapping("account")
    public String addAccount(Account account){
        account.setVip(false);
        accountMapper.insertAccount(account);
        //关联表的添加
        Integer id = (Integer)accountMapper.getAccountByUsername(account.getUserName()).getId();
        Pay pay = new Pay();
        pay.setId(id);
        pay.setManage(0);
        pay.setGas(0);
        pay.setElectric(0);
        pay.setWater(0);
        payMapper.insertPay(pay);
        //来到账号列表
        return "redirect:/accounts";
    }

    //来到账号修改页面
    @GetMapping("account/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Account account = accountMapper.getAccountById(id);
        model.addAttribute("account",account);
        return "account/add";
    }

    //员工修改请求
    @PutMapping("account")
    public String updateAccount(Account account){
        accountMapper.updateAccount(account);
        System.out.println(account);
        return "redirect:/accounts";
    }

    //员工删除请求
    @DeleteMapping("account/{id}")
    public String deleteAccount(@PathVariable("id") Integer id){
        accountMapper.deleteAccountById(id);
        return "redirect:/accounts";
    }


}
