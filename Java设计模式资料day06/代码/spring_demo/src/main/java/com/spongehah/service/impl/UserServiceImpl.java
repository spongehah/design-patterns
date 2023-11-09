package com.spongehah.service.impl;

import com.spongehah.dao.UserDao;
import com.spongehah.service.UserService;

public class UserServiceImpl implements UserService {
    
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("UserServiceImpl.....");
        userDao.add();
    }
}
