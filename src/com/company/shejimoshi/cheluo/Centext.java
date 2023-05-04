package com.company.shejimoshi.cheluo;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/4 10:58 上午
 * @Description:
 */
public class Centext {
    public Starate starate;

    public Centext(Starate starate) {
        this.starate = starate;
    }
    public void execton(){
        starate.demo(starate.getClass().getName());
    }
}
