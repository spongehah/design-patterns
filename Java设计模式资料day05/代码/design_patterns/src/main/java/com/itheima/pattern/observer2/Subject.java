package com.itheima.pattern.observer2;

public interface Subject {
    
    public void addObserver(Observer observer);
    
    public void delObserver(Observer observer);
    
    public void notifyAll(String message);
}
