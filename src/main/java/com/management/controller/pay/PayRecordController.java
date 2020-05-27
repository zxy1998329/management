package com.management.controller.pay;

import com.management.entity.PayRecord;
import com.management.mapper.PayRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PayRecordController {
    @Autowired
    PayRecordMapper payRecordMapper;

    //查看一个人的缴费记录
    @GetMapping("/payRecord/{id}")
    public String onePage(@PathVariable("id")Integer id, Model model){
        List<PayRecord> payRecords = payRecordMapper.findPayRecordByOwnerId(id);
        model.addAttribute("payRecords",payRecords);
        return "payRecord/list";
    }

    //查看所有的缴费记录
    @GetMapping("/payRecords")
    public String list(Model model){
        List<PayRecord> payRecords = payRecordMapper.findAll();
        model.addAttribute("payRecords",payRecords);
        return "payRecord/list";
    }
}
