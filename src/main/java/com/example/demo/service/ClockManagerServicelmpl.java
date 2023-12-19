package com.example.demo.service;

import com.example.demo.dao.ClockDao;
import com.example.demo.model.Habit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClockManagerServicelmpl implements ClockManagerService {

    @Resource
    ClockDao clockDao;
//    展示未签到的习惯
     public List<Habit> getUnSignedHabitsByUser(String user_id){

         return clockDao.getUnSignedHabitsByUser(user_id);
    }


//  签到
    public String attendance(String habit_id,int state){
        String res;
        if (state != 1 && state != 2 && state != 3) {
            res = "alert('state只能为1、2、3')";
            return res;
        }

        int rowsAffected = clockDao.attendance(habit_id,state);
        if (rowsAffected > 0 ){
            res = "alert('签到成功!');location.reload();";
        }else {
            res = "alert('签到失败或已经签过到了')";
        }
        return res;
    }
}
