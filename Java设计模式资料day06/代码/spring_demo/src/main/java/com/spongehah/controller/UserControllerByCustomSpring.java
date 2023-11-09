package com.spongehah.controller;


import com.spongehah.context.ApplicationContext;
import com.spongehah.context.support.ClassPathXmlApplicationContext;
import com.spongehah.service.UserService;

/**
 * 测试使用自定义Spring
 * 注意上面import的包，都是com.itheima下的
 */
public class UserControllerByCustomSpring {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.add();
        
        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserService userService1 = applicationContext1.getBean("userService", UserService.class);

        System.out.println(userService == userService1);
    }
}
