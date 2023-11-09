package com.itheima.pattern.bridge2;

public class Client {

    public static void main(String[] args) {
        OS macOS = new MacOS(new AviFile());
        macOS.play("战狼3");
    }
}
