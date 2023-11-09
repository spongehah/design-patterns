package com.itheima.pattern.factory2.config_factory;

public class Client {

    public static void main(String[] args) {
        CoffeeFactory coffeeFactory = new CoffeeFactory();
        Coffee c1 = null;
        Coffee c2 = null;
        try {
            c1 = coffeeFactory.createCoffee("american");
            c2 = coffeeFactory.createCoffee("american");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(c1.getName());
        System.out.println(c1 == c2);
        
    }
}
