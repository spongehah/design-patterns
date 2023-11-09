package com.itheima.pattern.adapter2.object_adapter;

public class Computer {
    
    public  String readSD(SDCard sdCard) {
        if (sdCard == null) {
            throw new NullPointerException("sd card is null");
        }
        return sdCard.readSD();
    }
}
