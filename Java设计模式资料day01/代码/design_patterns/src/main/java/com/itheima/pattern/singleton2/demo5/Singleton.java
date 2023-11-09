package com.itheima.pattern.singleton2.demo5;

public class Singleton {
    
    private Singleton () {}
    
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
