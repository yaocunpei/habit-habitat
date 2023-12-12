package com.example.demo.service;


import com.example.demo.model.User;

import javax.servlet.http.HttpSession;

public interface UserManagerService {
    public User loadUserByUsername(String id);
    public String chkuser(String stunum, String stuphone, String pw, HttpSession session);
    public String edituser(User user, String id);
}
