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
     public List<Habit> getUnSignedHabitsByUser(String user_id){

        return clockDao.getUnSignedHabitsByUser(user_id);
    }
}
