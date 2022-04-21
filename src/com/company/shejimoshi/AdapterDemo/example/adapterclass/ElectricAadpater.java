package com.company.shejimoshi.AdapterDemo.example.adapterclass;

import com.company.shejimoshi.AdapterDemo.example.Target;
import com.company.shejimoshi.AdapterDemo.example.adaptee.ElectricMotor;
import com.company.shejimoshi.AdapterDemo.example.adaptee.OpticalMotor;

/**
 * @Author: wenjie.li
 * @Date: 2022/4/21 12:10 上午
 * @Description:
 */
public class ElectricAadpater  extends ElectricMotor implements Target{

    @Override
    public void diver(){
        motor();
    }
}
