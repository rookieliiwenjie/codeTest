package com.company.shejimoshi.singed;

/**
 * @Author: wenjie.li
 * @Date: 2022/5/16 12:07 上午
 * @Description:
 */
public class SingLeton {

    private SingLeton singLeton;

    public SingLeton getSingLeton() {
        if (singLeton == null) {
            synchronized (SingLeton.class) {
                if (singLeton != null) {
                    return singLeton;
                }
                singLeton = new SingLeton();
            }
        }
        return singLeton;

    }
}
