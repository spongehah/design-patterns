package com.itheima.pattern.proxy2.jdk_proxy;

public class TrainStation implements SellTickets{

    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
