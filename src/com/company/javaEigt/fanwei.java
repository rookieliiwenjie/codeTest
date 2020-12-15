package com.company.javaEigt;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author rookie.li
 * @create 2020/12/8
 */
public class fanwei {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("args.toString() = " + args.toString());
            }
        };
        thread.start();
        new Thread(()->{
            System.out.println(" ==== " );
        }).start();
        List<Integer> integerList = new ArrayList<>();

        //thread.run();
       /* FunctionIn<Integer, String> functionIn = (from) -> Integer.parseInt(from);
        System.out.println("functionIn = " + functionIn.Conerf("1"));*/
    }
}
