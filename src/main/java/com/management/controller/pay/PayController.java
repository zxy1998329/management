package com.management.controller.pay;

import com.management.entity.Account;
import com.management.entity.Pay;
import com.management.mapper.AccountMapper;
import com.management.mapper.PayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
public class PayController {
    @Autowired
    PayMapper payMapper;
    @Autowired
    AccountMapper accountMapper;

    //业主自己查看缴费情况
    @GetMapping("/pay")
    public String getPay(Model model, HttpSession session){
        Integer id = (Integer) session.getAttribute("id");
        Pay pay = payMapper.getPayById(id);
        Account account = accountMapper.getAccountById(id);
        model.addAttribute("pay",pay);
        model.addAttribute("account",account);
        return "/pay";
    }

    //管理员查看缴费情况
    @GetMapping("/pay/{id}")
    public String managePay(@PathVariable("id") Integer id,Model model){
        Pay payById = payMapper.getPayById(id);
        Account accountById = accountMapper.getAccountById(id);
        model.addAttribute("account",accountById);
        model.addAttribute("pay",payById);
        return "account/pay";
    }

}
