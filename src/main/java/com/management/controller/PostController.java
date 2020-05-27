package com.management.controller;

import com.management.entity.Liuyan;
import com.management.entity.Post;
import com.management.mapper.AccountMapper;
import com.management.mapper.LiuyanMapper;
import com.management.mapper.PostMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    PostMapper postMapper;

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    LiuyanMapper liuyanMapper;

    //社区主页
    @GetMapping("/posts")
    public String list(Model model){
        List<Post> posts = postMapper.findAllWithComment();
        model.addAttribute("posts",posts);
        //板块按钮高亮
        model.addAttribute("part",(Integer)0);
        return "post/list";
    }

    //主页的其他板块
    @GetMapping("/posts/{part}")
    public String otherList(@PathVariable("part")Integer part,Model model){
        List<Post> posts = postMapper.findByPart(part);
        model.addAttribute("posts",posts);
        model.addAttribute("part",part);
        return "post/list";
    }

    //管理帖子页面
    @GetMapping("/myposts")
    public String myList(HttpSession session, Model model){
        //是管理员则获取所有帖子
        if((boolean)session.getAttribute("vip")){
            List<Post> posts = postMapper.findAll();
            model.addAttribute("posts",posts);
        }
        else{
            Integer id = (Integer)session.getAttribute("id");
            List<Post> posts = postMapper.findByOwnerId(id);
            model.addAttribute("posts",posts);
        }
        return "post/mylist";
    }

    //添加帖子页面
    @GetMapping("/post")
    public String addPage(){
        return "post/add";
    }

    //添加帖子请求
    @PostMapping("/post")
    public String add(Post post,HttpSession session){
        post.setDate(new Date());
        post.setOwnerId((Integer)session.getAttribute("id"));
        post.setOwnerNickName((String)session.getAttribute("nickName"));
        postMapper.insertPost(post);
        return "redirect:/myposts";
    }

    //修改帖子页面
    @GetMapping("/post/{id}")
    public String editPage(@PathVariable("id") Integer id,Model model){
        Post post = postMapper.findById(id);
        model.addAttribute("post",post);
        return "post/add";
    }

    //修改帖子请求
    @PutMapping("/post")
    public String edit(Post post){
        postMapper.updatePost(post);
        return "redirect:/myposts";
    }

    //删除帖子请求
    @DeleteMapping("/post/{id}")
    public String delete(@PathVariable("id")Integer id){
        postMapper.deletePostById(id);
        return "redirect:/myposts";
    }
}
