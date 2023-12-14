package com.example.demo.controller;

import com.example.demo.model.Habit;
import com.example.demo.service.HabitManagerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@CrossOrigin
public class EditHabitController {
    @Resource
    private HabitManagerService habitManagerService;

    @PostMapping("/edithabit")
    @ResponseBody
    String edithabit(int habit_id, Date startdate,Date enddate,String description, HttpSession session){
        String res;
        Habit habit = new Habit();
        habit.setHabit_id(habit_id);
        habit.setStart_date(startdate);
        habit.setEnd_date(enddate);
        habit.setDescription(description);

        res = habitManagerService.editHabit(habit);
        return  res;
    }
}
