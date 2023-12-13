package com.example.demo.service;

import com.example.demo.model.Habit;

import java.util.List;

public interface HabitManagerService {
    List<Habit> loadHabitByUserid(String id);
}
