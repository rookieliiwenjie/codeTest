package com.company.shejimoshi.Observer.observer;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/11 11:43 下午
 * @Description:
 */
public abstract class AbstractPayAction {
    public AbstractPayAction(String name) {
        this.name = name;
    }

    public String name;
    public abstract void payAction(String produce);

}
