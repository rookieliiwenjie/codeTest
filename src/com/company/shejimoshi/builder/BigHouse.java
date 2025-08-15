package com.company.shejimoshi.builder;

public class BigHouse extends HouseBuilder {

    @Override
    public void buildFoundation() {
        house.setFoundation("Big");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Big");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Big");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Big");
    }
}
