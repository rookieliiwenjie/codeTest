package com.company.shejimoshi.Observer.observer;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/11 11:44 下午
 * @Description:
 */
public class ZfbPay extends AbstractPayAction {

    public ZfbPay(String name) {
        super(name);
    }

    @Override
    public void payAction(String name) {
        System.out.println(name + "记录一笔");
    }
}
