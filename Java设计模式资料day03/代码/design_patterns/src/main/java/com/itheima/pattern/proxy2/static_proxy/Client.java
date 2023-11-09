package com.itheima.pattern.proxy2.static_proxy;

public class Client {

    public static void main(String[] args) {
        ProxyPoint proxy = new ProxyPoint();
        proxy.sell();
    }
}
