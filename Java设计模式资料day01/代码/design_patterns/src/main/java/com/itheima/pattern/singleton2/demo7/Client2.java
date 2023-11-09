package com.itheima.pattern.singleton2.demo7;

import java.lang.reflect.Constructor;

public class Client2 {

    public static void main(String[] args) throws Exception {
        Class<Singleton> clazz = Singleton.class;
        Constructor<Singleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton s1 = constructor.newInstance();
        Singleton s2 = constructor.newInstance();
        System.out.println(s1 == s2);//false
    }
}
