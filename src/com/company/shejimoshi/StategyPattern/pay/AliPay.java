package com.company.shejimoshi.StategyPattern.pay;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/18 5:18 下午
 * @Description:
 */
public class AliPay extends AbstractPay{
    @Override
    public void createPayRequest(String payKey) {
        System.out.println("AliPay.createPayRequest"+payKey);
    }
}
