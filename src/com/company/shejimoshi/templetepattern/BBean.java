package com.company.shejimoshi.templetepattern;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-11-10 16:05
 */
public class BBean extends BeanDemo {
    @Override
    void init() {
        System.out.println("Binit = ");
    }

    @Override
    void start() {
        System.out.println("Bstart = ");
    }

    @Override
    void end() {
        System.out.println("Bend = ");
    }
}
