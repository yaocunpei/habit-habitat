package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.service.UserManagerService;
import com.example.demo.service.UserSignService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class EditUserController {
    @Resource
    UserManagerService userManagerService;

    @PostMapping("/edituser")
    @ResponseBody
    public String edituser(String name, String email, String phone, String biography ,int gender,HttpSession session){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setBiography(biography);
        user.setGender(gender);
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        String userId = (String) session.getAttribute("id");

        if (loggedIn != null && loggedIn) {

            return userManagerService.edituser(user, userId);
        } else {
            // 用户未登录，重定向到登录页面
            return "redirect:/login";
        }
    }
}
