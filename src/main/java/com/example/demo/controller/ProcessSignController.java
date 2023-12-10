package com.example.demo.controller;


import com.example.demo.service.UserManagerService;
import com.example.demo.service.UserSignService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class ProcessSignController {
    @Resource
    UserSignService usersignService;

    @PostMapping("/processsign")
    @ResponseBody
    public  String processsign(String stunum,String stuphone,String pw,String stuname){
        String res =usersignService.sign(stunum,stuphone,pw,stuname);
        return res;
    }
}
