package com.company.shejimoshi.BuilderDemo.InterfeceImpl;

import com.company.shejimoshi.BuilderDemo.InterfeceImpl.ItmeImpl.BurgerFather.Impl.ChickenBurger;
import com.company.shejimoshi.BuilderDemo.InterfeceImpl.ItmeImpl.BurgerFather.Impl.VegBurger;
import com.company.shejimoshi.BuilderDemo.InterfeceImpl.ItmeImpl.DrinkFather.Impl.CoKe;
import com.company.shejimoshi.BuilderDemo.InterfeceImpl.ItmeImpl.DrinkFather.Impl.Pepsi;

/**
 * @Author rookie.li
 * @create 2020/11/20
 */
public class MealBuilder {
    public Meal chickenAndCokeMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new CoKe());
        return meal;
    }

    public Meal veAndPepsiMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
