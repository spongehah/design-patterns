package com.itheima.pattern.factory2.factory_method;

public class CoffeeStore {
    private CoffeeFactory coffeeFactory;
    
    public void setCoffeeFactory(CoffeeFactory coffeeFactory){
        this.coffeeFactory = coffeeFactory;
    }
    
    public Coffee orderCoffee() {
        Coffee coffee = coffeeFactory.createCoffee();
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
