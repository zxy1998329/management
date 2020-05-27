package com.management.component;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//登陆拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("id");
        if(loginUser == null){
            //未登录
            request.setAttribute("msg","没有权限请先登陆");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        else{
            //已登录
            return true;
        }
    }
}
