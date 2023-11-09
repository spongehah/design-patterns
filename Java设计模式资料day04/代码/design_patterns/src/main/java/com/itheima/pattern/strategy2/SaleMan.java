package com.itheima.pattern.strategy2;

public class SaleMan {
    
    private Strategy strategy;

    public SaleMan(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public void saleManShow() {
        strategy.show();
    }
}
