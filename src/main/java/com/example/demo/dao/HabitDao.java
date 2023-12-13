package com.example.demo.dao;

import com.example.demo.model.Habit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HabitDao {
    List<Habit> getHabitById(String id);
}
