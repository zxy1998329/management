package com.management.controller;

import com.management.entity.Liuyan;
import com.management.mapper.LiuyanMapper;
import org.apache.ibatis.annotations.Delete;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class LiuyanController {
    @Autowired
    LiuyanMapper liuyanMapper;

    //自己的留言页面
    @GetMapping("/liuyans")
    public String list(Model model, HttpSession session){
        List<Liuyan> liuyans = liuyanMapper.findLiuyanByOwnerId((Integer)session.getAttribute("id"));
        model.addAttribute("liuyans",liuyans);
        return "liuyan/list";
    }

    //删除请求
    @DeleteMapping("/liuyan/{id}")
    public String delete(@PathVariable("id")Integer id){
        liuyanMapper.deleteLiuyanById(id);
        return "redirect:/liuyans";
    }

    //添加留言页面
    @GetMapping("/liuyan")
    public String addPage(@RequestParam("ownerId")Integer ownerId,
                          @RequestParam("postTitle")String postTitle,
                          Model model){
        model.addAttribute("ownerId",ownerId);
        model.addAttribute("postTitle",postTitle);
        return "liuyan/add";
    }

    //添加请求
    @PostMapping("/liuyan")
    public String add(Liuyan liuyan,HttpSession session){
        liuyan.setDate(new Date());
        liuyan.setLeaveId((Integer) session.getAttribute("id"));
        liuyan.setLeaveUserName((String)session.getAttribute("userName"));
        liuyanMapper.insertLiuyan(liuyan);
        return "redirect:/posts";
    }

}
