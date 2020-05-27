package com.management.controller.payment;

import com.management.entity.Account;
import com.management.entity.Pay;
import com.management.entity.PayRecord;
import com.management.mapper.AccountMapper;
import com.management.mapper.PayMapper;
import com.management.mapper.PayRecordMapper;
import com.management.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class ElectricController {
    @GetMapping("payment_electric")
    public String get(){
        return "payment/electric";
    }

    @Autowired
    PayMapper payMapper;

    @Autowired
    PayService payService;

    @Autowired
    PayRecordMapper payRecordMapper;

    @Autowired
    AccountMapper accountMapper;

    //业主自己缴费
    @PostMapping("payment_electric")
    public String post(Integer money, HttpSession session){
        int id = (int)session.getAttribute("id");
        String userName = (String )session.getAttribute("userName");
        //添加缴费记录
        PayRecord payRecord = new PayRecord();
        payRecord.setOwnerId(id);
        payRecord.setOwnerUserName(userName);
        payRecord.setType(2);
        payRecord.setMoney(money);
        payRecord.setDate(new Date());
        payRecordMapper.insertPayRecord(payRecord);


        Pay pay = payMapper.getPayById(id);
        payService.addElectric(pay,money);
        return "redirect:pay";
    }

    //管理员进入缴费页面
    @GetMapping("/payment_electric/{id}")
    public String waterManageGet(@PathVariable("id") Integer id,Model model){
        model.addAttribute("id",id);
        return "account/payment/electric";
    }

    //管理员给业主缴费
    @PostMapping("payment_electric/{id}")
    public String waterManagePost(@PathVariable("id") Integer id,Integer money,Model model){
        Account account = accountMapper.getAccountById(id);
        String userName = account.getUserName();
        //添加缴费记录
        PayRecord payRecord = new PayRecord();
        payRecord.setOwnerId(id);
        payRecord.setOwnerUserName(userName);
        payRecord.setType(2);
        payRecord.setMoney(money);
        payRecord.setDate(new Date());
        payRecordMapper.insertPayRecord(payRecord);

        Pay pay = payMapper.getPayById(id);
        payService.addElectric(pay,money);
        return "redirect:/pay/"+id;
    }
}
