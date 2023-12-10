package com.example.demo.dao;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User getUserById(String id);
    int registerUser(String stunum, String stuphone, String pw, String stuname);
}
