package com.company.shejimoshi.Observer;

import com.company.shejimoshi.Observer.observer.AbstractPayAction;
import com.company.shejimoshi.Observer.observer.WxPay;
import com.company.shejimoshi.Observer.observer.ZfbPay;
import com.company.shejimoshi.Observer.subject.PayDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/11 11:46 下午
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        AbstractPayAction wxPay = new WxPay("wx");
        AbstractPayAction zfbPay = new ZfbPay("zfb");
        PayDemo payDemo = new PayDemo();
        payDemo.registry(wxPay);
        payDemo.registry(zfbPay);
        payDemo.pay();
        wxPay.name="";
    }
}
