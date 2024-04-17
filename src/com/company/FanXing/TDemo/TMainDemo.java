package com.company.FanXing.TDemo;

import com.company.FanXing.domain.Anmail;
import com.company.FanXing.domain.Dog;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/24 3:03 下午
 * @Description:
 */
public class TMainDemo {
    public static void main(String[] args) {
//        TDemo tDemo = new TDemo();
//        tDemo.getData(1);
//        T2Demo t2Demo = new T2Demo();
//        t2Demo.getData(tDemo);
//        T3Demo t3Demo = new T3Demo();
//        t3Demo.getData(1);


        WDemo wDemo = new WDemo();
        List<Anmail> list = new ArrayList<>();
        wDemo.getLe(list);
        List<Dog> listdog = new ArrayList<>();
        wDemo.getLe(listdog);
        //报错        wDemo.getLe2(listdog);
    }
}
