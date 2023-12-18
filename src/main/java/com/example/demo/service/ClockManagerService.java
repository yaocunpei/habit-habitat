package com.example.demo.service;

import com.example.demo.model.Habit;

import java.util.List;

public interface ClockManagerService {

    public List<Habit> getUnSignedHabitsByUser(String user_id);
}
