package com.itheima.pattern.flyweight2;

public class Client {

    public static void main(String[] args) {
        AbstractBox lBox = BoxFactory.getInstance().getBox("L");
        lBox.display("黄色");

        AbstractBox iBox = BoxFactory.getInstance().getBox("I");
        iBox.display("黄色");

        AbstractBox OBox = BoxFactory.getInstance().getBox("O");
        OBox.display("黄色");

        AbstractBox OBox2 = BoxFactory.getInstance().getBox("O");
        OBox.display("红色");

        System.out.println(OBox == OBox2);
    }
}
