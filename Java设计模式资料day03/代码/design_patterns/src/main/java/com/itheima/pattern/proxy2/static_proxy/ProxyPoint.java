package com.itheima.pattern.proxy2.static_proxy;

public class ProxyPoint implements SellTickets{

    private TrainStation station = new TrainStation();
    
    @Override
    public void sell() {
        System.out.println("代理点收取一些费用");
        station.sell();
    }
}
