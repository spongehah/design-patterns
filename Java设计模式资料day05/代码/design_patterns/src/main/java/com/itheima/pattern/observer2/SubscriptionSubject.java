package com.itheima.pattern.observer2;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject{

    private List<Observer> weixinUserList = new ArrayList<>();
    
    @Override
    public void addObserver(Observer observer) {
        weixinUserList.add(observer);
    }

    @Override
    public void delObserver(Observer observer) {
        weixinUserList.remove(observer);
    }

    @Override
    public void notifyAll(String message) {
        for (Observer observer : weixinUserList) {
            observer.update(message);
        }
    }
}
