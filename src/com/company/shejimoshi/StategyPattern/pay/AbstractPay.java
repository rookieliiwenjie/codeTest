package com.company.shejimoshi.StategyPattern.pay;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/18 5:07 下午
 * @Description:
 */
public abstract class AbstractPay {

    /**
     * 创建支付请求
     *
     * @param paykey paykey
     */
    public abstract void createPayRequest(String payKey);

    public String pay(String payKey){
        createPayRequest(payKey);
        System.out.println("支付方式 = " + payKey);
        return payKey;
    }
}
