package com.company;

/**
 * @Author rookie.li
 * @create 2020/10/27
 */
@Auth(EnumDemo = Auth.EnumDemo.FRIST, neii = "apple")

public class Apple {
    public Apple(String name) {
        this.name = name;
    }

    @Auth(EnumDemo = Auth.EnumDemo.FRIST, neii = "name")
    private String name;
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    @Auth(EnumDemo = Auth.EnumDemo.TWO, neii = "setprice")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
