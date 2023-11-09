package com.itheima.pattern.singleton2.demo7;

import java.io.Serializable;

public class Singleton implements Serializable {
    private Singleton () {
        synchronized (Singleton.class) {
            if (flag) {
                RuntimeException runtimeException = new RuntimeException("不能创建多个单例对象！");
                runtimeException.printStackTrace();
            }
            flag = true;
        }
    }
    
    private static boolean flag = false;
    
    private static class SingletonHolder {
        public static final Singleton INSTANCE = new Singleton();
    }
    
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    //解决因反序列化引起的破坏单例模式
    public Object readResolve() {
        return SingletonHolder.INSTANCE;
    }
}
