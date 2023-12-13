package com.example.demo.service;

import com.example.demo.dao.HabitDao;
import com.example.demo.model.Habit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HabitManagerServicelmpl implements HabitManagerService{

    public List<Habit> habit;
    @Resource
    public  HabitDao habitDao;
    public List<Habit> loadHabitByUserid(String id){
        habit = habitDao.getHabitById(id);
        return habit;
    }
}
