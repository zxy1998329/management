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
public class GasController {
    @GetMapping("payment_gas")
    public String get(){
        return "payment/gas";
    }

    @Autowired
    PayService payService;

    @Autowired
    PayMapper payMapper;

    @Autowired
    PayRecordMapper payRecordMapper;

    @Autowired
    AccountMapper accountMapper;

    @PostMapping("payment_gas")
    public String waterPost(Integer money, HttpSession session){
        int id = (int)session.getAttribute("id");
        String userName = (String )session.getAttribute("userName");
        //添加缴费记录
        PayRecord payRecord = new PayRecord();
        payRecord.setOwnerId(id);
        payRecord.setOwnerUserName(userName);
        payRecord.setType(3);
        payRecord.setMoney(money);
        payRecord.setDate(new Date());
        payRecordMapper.insertPayRecord(payRecord);

        Pay pay = payMapper.getPayById(id);
        payService.addGas(pay,money);
        return "redirect:pay";
    }

    //管理员进入缴费页面
    @GetMapping("/payment_gas/{id}")
    public String waterManageGet(@PathVariable("id") Integer id, Model model){
        model.addAttribute("id",id);
        return "account/payment/gas";
    }

    //管理员给业主缴费
    @PostMapping("payment_gas/{id}")
    public String waterManagePost(@PathVariable("id") Integer id,Integer money,Model model){
        Account account = accountMapper.getAccountById(id);
        String userName = account.getUserName();
        //添加缴费记录
        PayRecord payRecord = new PayRecord();
        payRecord.setOwnerId(id);
        payRecord.setOwnerUserName(userName);
        payRecord.setType(3);
        payRecord.setMoney(money);
        payRecord.setDate(new Date());
        payRecordMapper.insertPayRecord(payRecord);

        Pay pay = payMapper.getPayById(id);
        payService.addGas(pay,money);
        return "redirect:/pay/"+id;
    }
}
