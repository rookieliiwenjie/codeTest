package com.company.shejimoshi.builder;

public class SmallHouse extends HouseBuilder{

    @Override
    public void buildFoundation() {
        house.setFoundation("Small");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Small");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Small");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Small");
    }
}
