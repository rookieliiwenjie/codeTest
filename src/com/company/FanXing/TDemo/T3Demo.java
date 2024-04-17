package com.company.FanXing.TDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/24 2:59 下午
 * @Description:
 */
public class T3Demo {
    //只接受Integer类型的入参
    public <T extends Integer> T getData(T data) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        return data;
    }

}
