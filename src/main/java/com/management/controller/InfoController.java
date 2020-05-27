package com.management.controller;

import com.management.entity.Account;
import com.management.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class InfoController {
    @Autowired
    AccountMapper accountMapper;

    //信息页面
    @GetMapping("info")
    public String getInfo(Model model,HttpSession session){
        Integer id = (Integer) session.getAttribute("id");
        Account account = accountMapper.getAccountById(id);
        model.addAttribute("account",account);

        return "info/list";
    }

    //修改页面
    @GetMapping("/infoAdd")
    public String addPage(Model model,HttpSession session){
        Integer id = (Integer) session.getAttribute("id");
        Account account = accountMapper.getAccountById(id);
        model.addAttribute("account",account);
        return "info/add";
    }

    //修改请求
    @PutMapping("info")
    public String putInfo(Account account,Model model,HttpSession session){
        accountMapper.updateAccount(account);
        //更新session
        session.setAttribute("userName",account.getUserName());
        session.setAttribute("nickName",account.getNickName());

        return "redirect:info";
    }

    //修改密码页面
    @GetMapping("/password")
    public String passwordPage(){
        return "info/password";
    }

    //修改密码请求
    @PutMapping("/password")
    public String passwordEdit(
            @RequestParam("oldPassword")String oldPassword,
            @RequestParam("newPassword")String newPassword,
            @RequestParam("newPassword1")String newPassword1,
            HttpSession session,
            Model model
    ){
        //拿到当前账户的密码
        Integer id = (Integer)session.getAttribute("id");
        String password = accountMapper.getPasswordById(id);;


        //旧密码错误
        if(oldPassword.equals(password)==false){
            model.addAttribute("msg","旧密码错误！请重新填写");
            return "info/password";
        }
        //旧密码正确但新密码两次不一致
        else if(newPassword.equals(newPassword1)==false){
            model.addAttribute("msg","新密码不一致！请重新填写");
            return "info/password";
        }
        //新密码与旧密码相同
        else if(newPassword.equals(oldPassword)==true){
            model.addAttribute("msg","新密码不能与旧密码相同！请重新填写");
            return "info/password";
        }
        //修改成功
        else{
            HashMap map = new HashMap();
            map.put("id",id);
            map.put("passWord",newPassword);
            accountMapper.updatePasswordById(map);
            return "redirect:/info";
        }

    }
}
