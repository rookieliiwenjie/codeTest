package com.company.FanXing.TDemo;

import com.company.FanXing.domain.Anmail;

import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/24 3:32 下午
 * @Description:
 */
public class WDemo {
    public int getLe(List<? extends Anmail> anmails) {
        int sum = 0;
        for (Anmail a : anmails) {
            sum += a.get(1);
        }
        return sum;
    }
    public int getLe2(List<  Anmail> anmails) {
        int sum = 0;
        for (Anmail a : anmails) {
            sum += a.get(1);
        }
        return sum;
    }
}
