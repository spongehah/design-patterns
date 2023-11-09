package com.itheima.pattern.observer2;

public class Client {

    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.addObserver(new WeixinUser("孙悟空"));
        subject.addObserver(new WeixinUser("猪悟能"));
        subject.addObserver(new WeixinUser("沙悟净"));
        
        subject.notifyAll("传智教育的知识专栏更新啦！！！");
    }
}
