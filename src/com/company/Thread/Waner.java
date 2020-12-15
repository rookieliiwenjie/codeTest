package com.company.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Waner {
    public static void main(String[] args) {
        String[] str = {"铁皮", "救护车", "漂移", "十字线", "探长", "飞过天", "爵士", "红蜘蛛", "震荡波", "擎天柱", "大黄蜂", "威震天", "热破", "补天士", "通天晓", "猛大帅"};
        List list = new ArrayList();
        List list1 = new ArrayList();
        for (int i = 0; i < str.length; i++) {
            list.add(str[i]);
        }
        while (true) {
            list1.clear();
            while (true) {
                Random random = new Random();
                int index = random.nextInt(list.size());
                Object s = list.get(index);
                list1.add(s);
                list.remove(index);
                if (list1.size() == 4) {
                    for (Object o : list1) {
                        System.out.print(o + " ");
                    }
                    break;
                }
            }
            System.out.println();
            if (list.size() == 0) {
                break;
            }
        }
    }
}