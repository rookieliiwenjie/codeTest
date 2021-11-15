package com.company.shejimoshi.templetepattern;

import com.company.SingleonDemo.A;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-11-10 16:06
 */
public class Main {

    public static void main(String[] args) {
        BeanDemo beanDemo = new ABean();
        beanDemo.go();
        beanDemo = new BBean();
        beanDemo.go();
    }
}
