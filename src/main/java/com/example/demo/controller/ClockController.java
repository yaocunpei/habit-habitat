package com.example.demo.controller;

import com.example.demo.service.ClockManagerService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

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

    @PostMapping("/buqian")
    @ResponseBody
    String buqian(String habit_id, @RequestParam("bqdate") @DateTimeFormat(pattern="yyyy-MM-dd") Date bqdate){

        return clockManagerService.buqian(habit_id,bqdate);
    }
}
