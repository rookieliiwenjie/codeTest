package com.company.shejimoshi.FactoryDemo2025;

public class ChannelStockFactory extends StockFactory{
    @Override
    StockQuery createStock() {
        return  new ChannelStockQuery();
    }
}
