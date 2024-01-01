package com.example.demo.dao;

import com.example.demo.model.Habit;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface ClockDao {
    List<Habit> getUnSignedHabitsByUser(String user_id);
    int attendance(String habit_id , int state);
    int buqian(String habit_id, Date bqdate );

    int getClockNumberByHabit_id(String habit_id);

    int getLocalDateClock(String habit_id);
}
