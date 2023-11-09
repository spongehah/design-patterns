package com.itheima.pattern.proxy2.cglib_proxy;

import com.itheima.pattern.proxy2.jdk_proxy.SellTickets;

public class TrainStation implements SellTickets {

    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
