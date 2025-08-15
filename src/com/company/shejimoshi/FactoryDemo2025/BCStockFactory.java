package com.company.shejimoshi.FactoryDemo2025;

public class BCStockFactory extends StockFactory{
    @Override
    StockQuery createStock() {
        return  new BCStockQuery();
    }
}
