package com.example.demo.controller;

import com.example.demo.model.Habit;
import com.example.demo.model.HabitReferral;
import com.example.demo.model.User;
import com.example.demo.service.ClockManagerService;
import com.example.demo.service.HabitManagerService;
import com.example.demo.service.UserManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {

    @Resource
    public UserManagerService userManagerService;
    @Resource
    public HabitManagerService habitManagerService;
    @Resource
    public ClockManagerService clockManagerService;

    public String id;
    public User user;
    public List<Habit> habit;

    @RequestMapping("/")
    public String home() {
        return "index"; // 返回默认视图名称
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

        List<Habit> habits = clockManagerService.getUnSignedHabitsByUser((String) session.getAttribute("id"));
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn != null && loggedIn) {
            // 用户已登录，返回受保护的页面
            model.addAttribute("habits",habits);
            this.id = (String) session.getAttribute("id");
            return "index";
        } else {
            // 用户未登录，重定向到登录页面
            return "redirect:/login";
        }
    }

//      用户信息
    @RequestMapping("/user")
    public String user(Model model,HttpSession session){

        user = userManagerService.loadUserByUsername(this.id);

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


        user = userManagerService.loadUserByUsername(this.id);
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
    public String habit(Model model, HttpSession session) {
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn != null && loggedIn) {

            String userId = (String) session.getAttribute("id");
            // 用户习惯
            List<Habit> userHabits = habitManagerService.loadHabitByUserid(userId);

            if (userHabits != null && !userHabits.isEmpty()) {
                // 将用户习惯返回前端
                model.addAttribute("habits", userHabits);
            } else {
                // 如果没有找到习惯，处理空值情况
                System.out.println("No habits found for user ID: " + userId);
            }

            // 用户已登录，返回受保护的页面
            return "habit";
        } else {
            // 用户未登录，重定向到登录页面
            return "redirect:/login";
        }
    }


    @RequestMapping("/habit_edit")
    public String habit_edit(Model model, @RequestParam(value = "id", required = false) String habit_id, HttpSession session){
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        Habit habit1;
        String userId = (String) session.getAttribute("id");
        if (loggedIn != null && loggedIn) {
            if (habit_id != null ){
                habit1 = habitManagerService.loadHabitByHabitid(habit_id);
                model.addAttribute("habit", habit1);
            }else {

                // 用户习惯
                List<Habit> userHabits = habitManagerService.loadHabitByUserid(userId);
                model.addAttribute("habit",userHabits.get(0));
            }

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
            List<HabitReferral> habitReferrals = habitManagerService.loadHabitReferralByUserid();
            model.addAttribute("habitReferrals",habitReferrals);
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
        String userId = (String) session.getAttribute("id");
        List<Habit> habits = clockManagerService.getUnSignedHabitsByUser(userId);
        if (loggedIn != null && loggedIn) {
            model.addAttribute("habits",habits);
            // 用户已登录，返回受保护的页面
            return "clock";
        } else {
            // 用户未登录，重定向到登录页面
            return "redirect:/login";
        }

    }

    @RequestMapping("/clock_buqian")
    public String clock_buqian(Model model, HttpSession session) {
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        if (loggedIn != null && loggedIn) {

            String userId = (String) session.getAttribute("id");
            // 用户习惯
            List<Habit> userHabits = habitManagerService.loadHabitByUserid(userId);

            if (userHabits != null && !userHabits.isEmpty()) {
                // 将用户习惯返回前端
                model.addAttribute("habits", userHabits);
            } else {
                // 如果没有找到习惯，处理空值情况
                System.out.println("No habits found for user ID: " + userId);
            }

            // 用户已登录，返回受保护的页面
            return "clock_buqian";
        } else {
            // 用户未登录，重定向到登录页面
            return "redirect:/login";
        }
    }

    @RequestMapping("/clock_detail")
    public String clock_detail(Model model, @RequestParam(value = "id", required = false) String habit_id, HttpSession session){
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        Habit habit1;
        String userId = (String) session.getAttribute("id");
        if (loggedIn != null && loggedIn) {
            if (habit_id != null ){
                habit1 = habitManagerService.loadHabitByHabitid(habit_id);
                String[] clock = clockManagerService.detail(habit_id,userId);
                model.addAttribute("habit", habit1);
                model.addAttribute("clock", clock);

            }else {

                // 用户习惯
                List<Habit> userHabits = habitManagerService.loadHabitByUserid(userId);
                model.addAttribute("habit",userHabits.get(0));
            }

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
