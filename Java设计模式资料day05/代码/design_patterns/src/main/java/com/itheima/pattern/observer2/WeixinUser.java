package com.itheima.pattern.observer2;

public class WeixinUser implements Observer{
    
    private String name;
    
    public WeixinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
