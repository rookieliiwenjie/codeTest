package com.company.Java;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
//这种玩法高级哈
import static com.company.Java.Demo.getNum2;

/**
 * @Author: wenjie.li
 * @Date: 2023/4/11 2:55 下午
 * @Description:
 */
public class FinalDemo {

    private final  int nmm = 1;
    private static final ConcurrentHashMap<Integer,Integer> hashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
//        String s= "abcd";
//        System.out.println("substring = " + s.substring(0, s.length()));
        HashMap<String,String> map = new HashMap<>();
        for(int i = 0 ;i<10000;i=i+2){
            map.put(String.valueOf(i+1),String.valueOf(i+5));
        }
        String s = map.get("5485");
        String s2 = map.get("100");
        System.out.println("map = " + map+"s="+s+"s2=="+s2);

    }
    public  void changeNum(){
        getNum2();

    }

}
