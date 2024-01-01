package com.example.demo.service;

import com.example.demo.model.Habit;
import com.example.demo.model.HabitReferral;

import java.util.List;

public interface HabitManagerService {
    List<Habit> loadHabitByUserid(String User_id);
    Habit loadHabitByHabitid(String habit_id);
    List<HabitReferral> loadHabitReferralByUserid();
    String editHabit(Habit habit);
    String newHabit(Habit habit);
}
