package com.example.demo.controller;

import com.example.demo.model.Habit;
import com.example.demo.service.HabitManagerService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

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
    String edithabit(
            int habit_id,
            @RequestParam("startdate") @DateTimeFormat(pattern="yyyy-MM-dd") Date startdate,
            @RequestParam("enddate") @DateTimeFormat(pattern="yyyy-MM-dd")Date enddate,
            String description,
            HttpSession session
    )
    {
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
