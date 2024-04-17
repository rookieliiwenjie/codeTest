package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class demoMain {
    public static void main(String[] args) {
        String s = "hello\nworld\nwoddrld\n";

        List<String> collect = Arrays.stream(s.split("\n")).collect(Collectors.toList());
        collect.forEach(s1 -> {
            if (s1.equals("hello")) {
                return;
            }
            System.out.println(s1);
        });
        System.out.println(collect);


    }
}
