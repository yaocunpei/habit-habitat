package com.example.demo.dao;

import com.example.demo.model.Habit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HabitDao {
    List<Habit> getHabitByUserId(String id);
    Habit getHabitByHabitID(String habit_id,String user_id);
    int editHabit(Habit habit);
    int newHabit(Habit habit);
}
