package com.company.javaEigt;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FunctionDemo {
    public static void main(String[] args) {
        FunctionDemo functionDemo = new FunctionDemo();
       // functionDemo.consumerDemo();
        functionDemo.BiFunctionDemo();

    }

    public void consumerDemo() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                s = s.toUpperCase();
                System.out.println("--consumer-" + s);
            }
        };
        Consumer<String> consumer1 = (String s) -> {
            s = s.toLowerCase();
            System.out.println("con1" + s);
        };
        consumer1.andThen(consumer).andThen(consumer).accept("hello world");
    }


    public void BiFunctionDemo() {
        BiFunction<String, String, String> biFunction = new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                System.out.println("apply");
                return s + s2;
            }
        };
        String apply = biFunction.andThen((String s) -> {
            System.out.println(s+"===");
            return s;
        }).apply("hello", "world");
        System.out.println(apply);
    }
}
