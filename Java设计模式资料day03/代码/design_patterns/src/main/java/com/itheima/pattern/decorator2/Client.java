package com.itheima.pattern.decorator2;

public class Client {

    public static void main(String[] args) {
        FastFood fastFood = new FriedRice();
        System.out.println(fastFood.getDesc() + ": " + fastFood.cost() + "元");

        System.out.println("=====================");

        FastFood eggRice = new Egg(fastFood);
        System.out.println(eggRice.getDesc() + ": " + eggRice.cost() + "元");

        System.out.println("========================");
        
        FastFood baconEggRice = new Bacon(eggRice);
        System.out.println(baconEggRice.getDesc() + ": " + baconEggRice.cost() + "元");
        
    }
}
