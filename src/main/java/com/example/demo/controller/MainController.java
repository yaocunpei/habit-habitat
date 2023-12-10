package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @RequestMapping("/login")
    public String login(Model model){

        return "login";
    }

    @RequestMapping("/sign")
    public String sgin(Model model){

        return "sign";
    }

    @RequestMapping("/index")
    public String index(Model model,HttpSession session){
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn != null && loggedIn) {
            // 用户已登录，返回受保护的页面
            return "index";
        } else {
            // 用户未登录，重定向到登录页面
            return "redirect:/login";
        }
    }

    @RequestMapping("/user")
    public String user(Model model,HttpSession session){
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn != null && loggedIn) {
            // 用户已登录，返回受保护的页面
            return "user";
        } else {
            // 用户未登录，重定向到登录页面
            return "redirect:/login";
        }
    }

    @RequestMapping("/user_edit")
    public String user_edit(Model model,HttpSession session){
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn != null && loggedIn) {
            // 用户已登录，返回受保护的页面
            return "user_edit";
        } else {
            // 用户未登录，重定向到登录页面
            return "redirect:/login";
        }
    }

    @RequestMapping("/habit")
    public String habit(Model model,HttpSession session){
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn != null && loggedIn) {
            // 用户已登录，返回受保护的页面
            return "habit";
        } else {
            // 用户未登录，重定向到登录页面
            return "redirect:/login";
        }
    }

    @RequestMapping("/habit_edit")
    public String habit_edit(Model model,HttpSession session){
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn != null && loggedIn) {
            // 用户已登录，返回受保护的页面
            return "habit_edit";
        } else {
            // 用户未登录，重定向到登录页面
            return "redirect:/login";
        }

    }
    @RequestMapping("/habit_new")
    public String habit_new(Model model,HttpSession session){
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn != null && loggedIn) {
            // 用户已登录，返回受保护的页面
            return "habit_new";
        } else {
            // 用户未登录，重定向到登录页面
            return "redirect:/login";
        }
    }

    @RequestMapping("/habit_referral")
    public String habit_referral(Model model,HttpSession session){
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn != null && loggedIn) {
            // 用户已登录，返回受保护的页面
            return "habit_referral";
        } else {
            // 用户未登录，重定向到登录页面
            return "redirect:/login";
        }

    }
    @RequestMapping("/clock")
    public String clock(Model model,HttpSession session){
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn != null && loggedIn) {
            // 用户已登录，返回受保护的页面
            return "clock";
        } else {
            // 用户未登录，重定向到登录页面
            return "redirect:/login";
        }

    }

    @RequestMapping("/clock_detail")
    public String clock_detail(Model model,HttpSession session){
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn != null && loggedIn) {
            // 用户已登录，返回受保护的页面
            return "clock_detail";
        } else {
            // 用户未登录，重定向到登录页面
            return "redirect:/login";
        }
    }
    @RequestMapping("/clock_history")
    public String clock_history(Model model,HttpSession session){
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn != null && loggedIn) {
            // 用户已登录，返回受保护的页面
            return "clock_history";
        } else {
            // 用户未登录，重定向到登录页面
            return "redirect:/login";
        }
    }


//   退出登录
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session属性
        session.removeAttribute("loggedIn");
        session.removeAttribute("id");
        // 使session失效
        session.invalidate();
        // 重定向到登录页面
        return "redirect:/login";
    }
}
