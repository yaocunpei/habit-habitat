package com.example.demo.service;

import com.example.demo.dao.HabitDao;
import com.example.demo.dao.HabitReferralDao;
import com.example.demo.model.Habit;
import com.example.demo.model.HabitReferral;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HabitManagerServicelmpl implements HabitManagerService{

    public List<Habit> habit;
    public List<HabitReferral> habitReferrals;
    @Resource
    public  HabitDao habitDao;
    @Resource
    public HabitReferralDao habitReferralDao;
    public List<Habit> loadHabitByUserid(String id){
        habit = habitDao.getHabitById(id);
        return habit;
    }

    public List<HabitReferral> loadHabitReferralByUserid(){
        habitReferrals = habitReferralDao.getHabitReferralById();
        return habitReferrals;
    }

    public String editHabit(String habit_id){
        String res;
        return res="";
    }
}
