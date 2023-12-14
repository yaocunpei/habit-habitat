package com.example.demo.service;

import com.example.demo.model.Habit;
import com.example.demo.model.HabitReferral;

import java.util.List;

public interface HabitManagerService {
    List<Habit> loadHabitByUserid(String id);
    List<HabitReferral> loadHabitReferralByUserid();
    String editHabit(String habit_id);
}
