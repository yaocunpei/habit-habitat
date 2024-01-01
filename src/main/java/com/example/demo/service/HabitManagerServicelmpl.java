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
    public List<Habit> loadHabitByUserid(String User_id){
        habit = habitDao.getHabitByUserId(User_id);
        return habit;
    }

    public Habit loadHabitByHabitid(String habit_id){
        Habit habit1;
        habit1 = habitDao.getHabitByHabitID(habit_id);
        return habit1;
    }
    public List<HabitReferral> loadHabitReferralByUserid(){
        habitReferrals = habitReferralDao.getHabitReferralById();
        return habitReferrals;
    }

    public String editHabit(Habit habit){
        String res;
        int rowsAffected = habitDao.editHabit(habit);
        if (rowsAffected > 0 ){
            res = "alert('修改成功');window.location.href = '/habit';";
            return res;
        }else{
            res="alert('修改失败');";
            return res;
        }
    }

    public String newHabit(Habit habit){
        String res;
        int rowsAffected = habitDao.newHabit(habit);
        if (rowsAffected > 0 ){
            res = "alert('添加成功');window.location.href = '/habit';";
            return res;
        }else{
            res="alert('添加失败');";
            return res;
        }
    }

}
