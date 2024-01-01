package com.example.demo.service;

import com.example.demo.dao.ClockDao;
import com.example.demo.dao.HabitDao;
import com.example.demo.model.Habit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class ClockManagerServicelmpl implements ClockManagerService {

    @Resource
    ClockDao clockDao;
    @Resource
    HabitDao habitDao;
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
            if(state==1)
                res = "alert('签到成功!');location.reload();";
            else
                res = "alert('请假成功!');location.reload();";
        }else {
            res = "alert('签到失败或已经签过到了')";
        }
        return res;
    }

    public String buqian(String habit_id, Date bqdate){
         String res = " ";
        int rowsAffected = clockDao.buqian(habit_id,bqdate);
        if (rowsAffected > 0 ){
            res = "alert('补签成功!');location.reload();";
        }else {
            res = "alert(补签失败或已经签过到了')";
        }
        return res;
    }

    public String[] detail(String habit_id,String user_id){
        Habit habit = habitDao.getHabitByHabitID(habit_id);
        LocalDate start_date = habit.getStart_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate end_date = habit.getEnd_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        // 获取当前日期
        LocalDate date = LocalDate.now();

        // 计算start_date和date之间的天数
        long daysBetweenStartAndNow = ChronoUnit.DAYS.between(start_date, date);
        // 计算start_date和end_date之间的天数
        long daysBetweenEndAndNow = ChronoUnit.DAYS.between(start_date, end_date);
        // 找到最小的天数
        long daysBetween = Math.min(daysBetweenStartAndNow, daysBetweenEndAndNow);

        int clocknumber = clockDao.getClockNumberByHabit_id(habit_id);

        int state = clockDao.getLocalDateClock(habit_id);

        String clockstate = "";
        System.out.println("两个日期之间的天数: " + daysBetween);
        System.out.println("打卡次数: " + clocknumber);
        if(state!=0){
            clockstate = "已打卡";
            System.out.println("打卡状态；" + clockstate);
        }else {
            clockstate = "未打卡";
            System.out.println("打卡状态；" + clockstate);
        }
        return new String[]{String.valueOf(clocknumber), String.valueOf(daysBetween),clockstate};
    }
}
