package com.company.LeetCode;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/4 9:35 上午
 * @Description:
 */
public class PowerDemo {

    public static double myPow(double x,int n){
        double num =1 ;
        if(n==0){
            return 1;
        }
        if(n<0){
            n =-n;
            x = 1/x;
        }
        for (int i = 0; i < n; i++) {
            num=num*x;
        }
        return num;
    }

    public static double myPow2(double x,int n){
        long N = n;
        return N >= 0 ? getNum(x, N) : getNum(1/x, -N);
    }

    public static double getNum(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = getNum(x, n / 2);
        return n % 2 == 0 ? (y * y) : (y * y * x);
    }
    public static void main(String[] args) {
        System.out.println("2/2 = " + 1/2);

   //     System.out.println("args = " +  myPow2(2,10));
    }
}
