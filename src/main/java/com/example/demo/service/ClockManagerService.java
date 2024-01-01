package com.example.demo.service;

import com.example.demo.model.Habit;

import java.util.Date;
import java.util.List;

public interface ClockManagerService {
    //    展示未签到的习惯
     List<Habit> getUnSignedHabitsByUser(String user_id);
    //  签到
     String attendance(String habit_id,int state);

     String buqian(String habit_id, Date bqdate);

     String[] detail(String habit_id,String user_id);
}
