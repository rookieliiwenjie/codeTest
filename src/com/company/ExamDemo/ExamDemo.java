package com.company.ExamDemo;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by lwj32 on 2020/8/30.
 */
public class ExamDemo {
    private static List<Integer> sSorted = new LinkedList<>();

    public static void main(String[] args) {
        sSorted.add(1);
        sSorted.add(2);
        sSorted.add(22);
        addElement(0);
        sSorted.forEach(number -> {
            System.out.println("number = " + number);
        });
        //System.out.println("args = " + sum(100));
    }

    public static int sum(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if (i == 2) {
                sum += 2;
                continue;
            }
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
                if (j == i - 1) {
                    sum = sum + i;
                }
            }
        }
        return sum;
    }

    public static void addElement(int e) {
        int size = sSorted.size();
        for (int i = 0; i < size; i++) {
            if ((e < sSorted.get(i) || e == sSorted.get(i))) {
                sSorted.add(i, e);
                break;
            }
        }
    }

}
