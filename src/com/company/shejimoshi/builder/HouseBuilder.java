package com.company.shejimoshi.builder;

public abstract class HouseBuilder {
    House house = new House();

    public abstract void buildFoundation();

    public abstract void buildStructure();

    public abstract void buildRoof();

    public abstract void buildInterior();

    public House getHouse() {
        return house;
    }


}
