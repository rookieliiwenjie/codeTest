package com.company.shejimoshi.StategyPattern.pay;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/18 5:20 下午
 * @Description:
 */
public class UnionPay extends AbstractPay{
    @Override
    public void createPayRequest(String payKey) {
        System.out.println("UnionPay.createPayRequest = " + payKey);
    }
}
