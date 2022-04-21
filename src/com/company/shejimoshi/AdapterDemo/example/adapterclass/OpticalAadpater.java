package com.company.shejimoshi.AdapterDemo.example.adapterclass;

import com.company.shejimoshi.AdapterDemo.example.Target;
import com.company.shejimoshi.AdapterDemo.example.adaptee.OpticalMotor;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/21 12:10 上午
 * @Description:
 */
public class OpticalAadpater extends OpticalMotor implements Target {

    @Override
    public void diver() {
        montor();
    }
}
