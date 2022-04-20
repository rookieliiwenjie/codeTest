package com.company.shejimoshi.StategyPattern.pay;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/18 5:19 下午
 * @Description:
 */
public class WechatPay extends AbstractPay{
    @Override
    public void createPayRequest(String payKey) {
        System.out.println("WechatPay.createPayRequest = " + payKey);
    }
}
