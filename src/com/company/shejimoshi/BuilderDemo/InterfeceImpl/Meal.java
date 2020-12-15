package com.company.shejimoshi.BuilderDemo.InterfeceImpl;

import com.company.shejimoshi.BuilderDemo.Interfece.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author rookie.li
 * @create 2020/11/20
 */
public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }
    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItem() {
        for (Item item : items) {
            System.out.println("item.name() = " + item.name());
            System.out.println("item.packing().pack() = " + item.packing().pack());
            System.out.println("item.price() = " + item.price());
        }
    }
}
