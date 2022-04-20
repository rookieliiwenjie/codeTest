package com.company.shejimoshi.StategyPattern.pay;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/18 6:36 下午
 * @Description:
 */
public class Context {
    AbstractPay abstractPay;

    public Context(AbstractPay abstractPay) {
        this.abstractPay = abstractPay;
    }
    public void doAction(String payKey){
        abstractPay.pay(payKey);
    }
}
