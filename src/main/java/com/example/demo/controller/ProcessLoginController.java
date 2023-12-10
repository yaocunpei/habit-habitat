package com.example.demo.controller;


import com.example.demo.service.UserManagerService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin
public class ProcessLoginController {
    @Resource
    UserManagerService userManagerService;

    @PostMapping("/processlogin")
    @ResponseBody
    public  String processlogin(String stunum, String stuphone, String pw, HttpSession session){
        String res =userManagerService.chkuser(stunum,stuphone,pw, session);
        return res;
    }
}
