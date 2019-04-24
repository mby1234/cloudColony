package com.cloudcolony.ordermodel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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

    private ExecutorService outerPool = Executors.newFixedThreadPool(2);

    @RequestMapping("/login")
    @ResponseBody
    public String toLogin3(HttpServletRequest request) {
        String name = request.getParameter("name");
        request.getSession().setAttribute("userId", name);
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Integer num = 0;
        Future result = pool.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    if(name!=null)throw new NullPointerException();
                    System.out.println("===========inner1:" + pool.toString() + "__" + Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        pool.submit(()->{
            System.out.println(2222222);
        });
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

    //测试git分支合并到master，并提交到远程
    public static void main(String[] args) {

    }
}
