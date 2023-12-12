package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Resource
    public   UserManagerService userManagerService;
    @Resource
    public String id;

    @RequestMapping("/")
    public String home() {
        return "login"; // 返回默认视图名称
    }
//    登录页面
    @RequestMapping("/login")
    public String login(Model model){

        return "login";
    }

//    注册页面
    @RequestMapping("/sign")
    public String sgin(Model model){

        return "sign";
    }

//    首页
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

//      用户信息
    @RequestMapping("/user")
    public String user(Model model,HttpSession session){

        User user = userManagerService.loadUserByUsername((String) session.getAttribute("id"));

//        性别
        String gender;
        if(user.getGender() == 1){
            gender = "男";
        }else {
            gender = "女";
        }

//        传参给前端
        model.addAttribute("name", user.getName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("phone", user.getPhone());
        model.addAttribute("gender", gender);
        model.addAttribute("biography", user.getBiography());


        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn != null && loggedIn) {
            // 用户已登录，返回受保护的页面
            return "user";
        } else {
            // 用户未登录，重定向到登录页面
            return "redirect:/login";
        }
    }

//    编辑个人信息
    @RequestMapping("/user_edit")
    public String user_edit(Model model,HttpSession session){


        User user = userManagerService.loadUserByUsername((String) session.getAttribute("id"));
//        性别
        String gender;
        if(user.getGender() == 1){
            gender = "男";
        }else {
            gender = "女";
        }
//        传参给前端
        model.addAttribute("name", user.getName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("phone", user.getPhone());
        model.addAttribute("gender", gender);
        model.addAttribute("biography", user.getBiography());
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

        String id = (String) session.getAttribute("id");


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
