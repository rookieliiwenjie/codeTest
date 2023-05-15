package com.company.shejimoshi.Observer.observer;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/11 11:44 下午
 * @Description:
 */
public class WxPay extends AbstractPayAction {

    public WxPay(String name) {
        super(name);
    }
    @Override
    public void payAction(String name) {
        if(name.contains("wx")){
            System.out.println(name + "记录一笔");
        }
    }

}
