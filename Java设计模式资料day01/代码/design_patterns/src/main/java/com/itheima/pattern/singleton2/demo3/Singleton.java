package com.itheima.pattern.singleton2.demo3;

/**
 * 单例模式-懒汉式
 */
public class Singleton {
    
    private Singleton() {}
    
    private static Singleton instance;
    
    public static Singleton getInstance(){
        return instance;
    }
}
