package com.itheima.pattern.builder2.demo2;


public class Client {

    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .setCpu("intel")
                .setScreen("三星屏幕")
                .setMemory("金士顿内存条")
                .setMainboard("华硕主板")
                .build();

        System.out.println(phone);
    }
}
