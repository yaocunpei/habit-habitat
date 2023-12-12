package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class UserManagerServiceImpl implements UserManagerService{
    @Resource
    private UserDao userDao;

    public User loadUserByUsername(String id){

        return userDao.getUserById(id);
    }
    public String chkuser(String stunum, String stuphone, String pw , HttpSession session){
        User user = userDao.getUserById(stunum);
        String passwd = user.getPasswd();
        String id = user.getId();
        String res ;

        if (pw.equals(passwd)){
            session.setAttribute("loggedIn", true);
            session.setAttribute("id", id);
            res = "alert('登陆成功');" +
                    "window.location.href = '/index';";
        }else{
            res = "alert('用户不存在或密码错误');";
        }
        return res;
    }

    public String edituser(User user, String id){
        String res = "";
        int rowsAffected = userDao.editUser(user,id);
        if(rowsAffected == 1){
            res = "alert('修改成功');window.location.href = '/user';";
        }else {
            res ="alert('修改失败');";
        }

        return res;

    }
}
