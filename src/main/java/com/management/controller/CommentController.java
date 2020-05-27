package com.management.controller;

import com.management.entity.Comment;
import com.management.entity.Post;
import com.management.mapper.CommentMapper;
import com.management.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    PostMapper postMapper;

    @Autowired
    CommentMapper commentMapper;

    //评论添加页面
    @GetMapping("/comment/{postId}")
    public String addPage(@PathVariable("postId")Integer postId, Model model){
        model.addAttribute("postId",postId);
        return "comment/add";
    }

    //评论添加请求
    @PostMapping("/comment")
    public String  add(Comment comment, HttpSession session){
        comment.setOwnerId((Integer) session.getAttribute("id"));
        comment.setOwnerNickName((String )session.getAttribute("nickName"));
        System.out.println(session.getAttribute("nickName"));
        comment.setDate(new Date());
        commentMapper.insertComment(comment);
        return "redirect:/posts";
    }
}
