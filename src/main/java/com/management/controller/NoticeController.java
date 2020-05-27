package com.management.controller;

import com.management.entity.Notice;
import com.management.mapper.NoticeMapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class NoticeController {
    @Autowired
    NoticeMapper noticeMapper;

    //进入编辑公告页面
    @GetMapping("/notices")
    public String list(Model model){
        List<Notice> notices = noticeMapper.getAll();
        model.addAttribute("notices",notices);
        return "notice/list";
    }

    //进入修改页面
    @GetMapping("/notice/{id}")
    public String editPage(@PathVariable("id") Integer id, Model model){
        Notice noticeById = noticeMapper.getNoticeById(id);
        model.addAttribute("notice",noticeById);
        return "notice/add";
    }

    //进入添加公告页面
    @GetMapping("/notice")
    public String addPage(){
        return "notice/add";
    }

    //修改请求
    @PutMapping("/notice")
    public String  edit(Notice notice){
        //时间设置为当前时间
        notice.setPublishDate(new Date());
        noticeMapper.updateNoticeById(notice);
        return "redirect:/notices";
    }

    //添加请求
    @PostMapping("/notice")
    public String add(Notice notice, HttpSession session){
        Integer ownerId = (Integer) session.getAttribute("id");
        notice.setOwnerId(ownerId);
        notice.setPublishDate(new Date());
        noticeMapper.insertNotice(notice);
        return "redirect:/notices";
    }

    //删除请求
    @DeleteMapping("/notice/{id}")
    public String delete(@PathVariable("id") Integer id){
        noticeMapper.deleteNoticeById(id);
        return "redirect:/notices";
    }

}
