package com.example.demo.dao;

import com.example.demo.model.HabitReferral;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HabitReferralDao {
    List<HabitReferral>  getHabitReferralById();
}
