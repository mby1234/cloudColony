package com.cloudcolony.ordermodel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginCon {

    @RequestMapping("")
    public String toLogin() {
        return "";
    }

    @RequestMapping("/")
    public String toLogin2() {
        return "";
    }


    @RequestMapping("/login")
    @ResponseBody
    public String toLogin3(HttpServletRequest request) {
        String name = request.getParameter("name");
        request.getSession().setAttribute("userId", name);
        return "登录成功：" + name + "____sysId：ORDER" + "____端口：" + request.getLocalPort();
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "退出登录";
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public String getName(HttpServletRequest request) {
        Object userId = request.getSession().getAttribute("userId");
        String name = userId == null ? "un Login" : userId.toString();
        return "当前用户：" + name + "____sysId：ORDER" + "____端口：" + request.getLocalPort();
    }
}
