package com.company.OOMDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwj32 on 2020/6/16.
 */
public class GcOverHeapLimitDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i =1;
        while (true){
            try {
                list.add(String.valueOf(i++).intern());

            }catch (Throwable throwable){
                System.out.println("i = " + i);
                throwable.printStackTrace();
                throw throwable;
            }finally {

            }
        }
    }
}
