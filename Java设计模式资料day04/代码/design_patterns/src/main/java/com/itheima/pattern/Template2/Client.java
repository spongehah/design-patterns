package com.itheima.pattern.Template2;

public class Client {

    public static void main(String[] args) {
        AbstractClass baocai = new ConcreteClass_BaoCai();
        baocai.cookProcess();
    }
}
