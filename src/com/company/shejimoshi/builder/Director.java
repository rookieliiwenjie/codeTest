package com.company.shejimoshi.builder;

//们创建指导者类 Director，它协调建造过程并返回构建的房屋对象
public class Director {
    HouseBuilder houseBuilder;

    public Director(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        houseBuilder.buildStructure();
        houseBuilder.buildFoundation();
        houseBuilder.buildInterior();
        houseBuilder.buildRoof();
        return houseBuilder.getHouse();
    }
}
