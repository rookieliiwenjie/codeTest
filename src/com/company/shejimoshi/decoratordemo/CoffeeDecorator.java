package com.company.shejimoshi.decoratordemo;

/**
 * 装饰器抽像类
 */
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratorCoffee;

    public CoffeeDecorator(Coffee decoratorCoffee) {
        this.decoratorCoffee = decoratorCoffee;
    }

    @Override
    public double getCost() {
        return decoratorCoffee.getCost();
    }

    @Override
    public String getDescription() {
        return decoratorCoffee.getDescription();
    }
}
