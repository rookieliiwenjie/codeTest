package com.company.shejimoshi.decoratordemo;

public class Main {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        MilkCoffee milkCoffee = new MilkCoffee(simpleCoffee);
        System.out.println(milkCoffee.getDescription());
        System.out.println(milkCoffee.getCost());
    }
}
