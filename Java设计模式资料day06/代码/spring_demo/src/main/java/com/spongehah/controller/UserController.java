package com.spongehah.controller;

import com.spongehah.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.add();
    }
}
