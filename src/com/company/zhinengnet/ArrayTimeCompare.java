package com.company.zhinengnet;

import java.util.Date;

/**
 * Created by lwj32 on 2020/11/2.
 *局部性原理
 * arr1() = 563
 * arr2() = 3846
 */
public class ArrayTimeCompare {
    public static void main(String[] args) {
        System.out.println("arr1() = " + arr1());
        System.out.println("arr2() = " + arr2());
    }
    public static long  arr1(){
        Date date = new Date();
        long time = date.getTime();
        long [][] a  = new long[10000][10000];
        
        for(int i = 0;i<a.length;i++){
            for (int j= 0;j<a[i].length;j++){
                a[i][j] = j;
            }
        }
        Date date1 = new Date();
        long time2 = date1.getTime();
       long timemax =  time2 -time;
       return timemax;
    }
    public static long  arr2(){
        Date date = new Date();
        long time = date.getTime();
        long [][] a  = new long[10000][10000];

        for(int i = 0;i<a.length;i++){
            for (int j= 0;j<a[i].length;j++){
                a[j][i] = j;
            }
        }
        Date date1 = new Date();
        long time2 = date1.getTime();
        long timemax =  time2 -time;
        return timemax;
    }
}
