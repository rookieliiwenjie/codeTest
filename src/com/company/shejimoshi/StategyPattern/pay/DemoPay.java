package com.company.shejimoshi.StategyPattern.pay;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/18 5:20 下午
 * @Description:
 */
public class DemoPay {
    public static void main(String[] args) {
        AbstractPay abstractPay = new AliPay();
        Context context = new Context(new AliPay());
        context.doAction("pay");
        abstractPay.pay("11");
    }
}
