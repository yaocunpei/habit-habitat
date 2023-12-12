package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserSignServiceImpl implements UserSignService{
    @Resource
    private UserDao userDao;

    @Override
    public String sign(String stunum, String stuphone, String pw, String stuname) {
        User existingUser = userDao.getUserById(stunum);
        String res;
        if (existingUser == null) {
            // ID不存在，执行插入操作
            int rowsAffected = userDao.registerUser(stunum,stuphone,pw,stuname);
            if(rowsAffected == 1){
                res = "alert('用户注册成功，即将返回登录页面！');window.location(\"/login\");";
                return res;
            }
        } else {
            // ID已存在，返回失败
            res ="alert('该用户已存在！')";
            return res;
        }
        res ="alert('注册失败！')";
        return res;
    }
}
