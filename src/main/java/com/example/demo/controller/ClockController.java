package com.example.demo.controller;

import com.example.demo.service.ClockManagerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
public class ClockController {
    @Resource
    ClockManagerService clockManagerService;

//    签到
    @PostMapping("/attendance")
    @ResponseBody
    String attendance(String habit_id,int state){

        return clockManagerService.attendance(habit_id,state);
    }
}
