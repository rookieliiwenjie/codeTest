package com.company.shejimoshi.FactoryDemo2025;

public class Main {
    public static void main(String[] args) {
        StockFactory  stockFactory = new ChannelStockFactory();
        StockQuery stock = stockFactory.createStock();
        stock.query();
    }
}
