package com.company.并发编程.day10_2021_02_20_dcl;

/**
 * @Author rookie.li
 * @create 2021/2/20
 */
public class InstanceFactory {
    private static class InstanceHolder {
        public static InstanceFactory instance = new InstanceFactory();
    }

    public static InstanceFactory getInstance() {
        return InstanceHolder.instance;  // 这里将导致InstanceHolder类被初始化
    }

}

