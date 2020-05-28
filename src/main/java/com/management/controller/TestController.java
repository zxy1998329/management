package com.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test/index";
    }

    @ResponseBody
    @GetMapping("/name")
    public Map name(){
        System.out.println("yes");
        HashMap map = new HashMap();
        map.put("name","zhang");
        return map;
    }
}
