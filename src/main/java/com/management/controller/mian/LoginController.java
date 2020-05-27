package com.management.controller.mian;

import com.management.entity.Account;
import com.management.mapper.AccountMapper;
import com.management.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class LoginController {
    @Autowired
    AccountService accountService;
    @Autowired
    AccountMapper accountMapper;

    //提交登录请求
    @PostMapping("/loginController")
    public String login(Account account, HttpSession session, Model model){
        Account accountByUsername = accountMapper.getAccountByUsername(account.getUserName());
        int stat = accountService.login(account);
        if(stat == 1){
            //登录成功
            session.setAttribute("vip",accountByUsername.isVip());
            session.setAttribute("id",accountByUsername.getId());
            session.setAttribute("userName",accountByUsername.getUserName());
            session.setAttribute("nickName",accountByUsername.getNickName());
            return "redirect:/homepage";
        }
        else if(stat == 0){
            //密码错误
            model.addAttribute("msg","密码错误");
            return "login";
        }
        else{
            //账号不存在
            model.addAttribute("msg","账号不存在！");
            return "login";
        }
    }

    //退出请求
    @GetMapping("/out")
    public String out(HttpSession session){
        //清楚session
        session.invalidate();
        return "redirect:/";
    }

}
