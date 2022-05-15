package com.company.shejimoshi.prototype.manger;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/22 5:31 下午
 * @Description:
 */
public interface Shape extends Cloneable{
    /**
     * 得到区域
     *
     * @return int
     */
    void getArea();

    /**
     * 克隆
     *
     * @return {@link Object}
     */
    Object clone();
}
