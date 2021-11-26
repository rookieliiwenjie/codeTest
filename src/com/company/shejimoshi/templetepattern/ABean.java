package com.company.shejimoshi.templetepattern;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-11-10 16:05
 */
public class ABean extends BeanDemo {
    @Override
    void init() {
        System.out.println("Ainit = ");
    }

    @Override
    void start() {
        System.out.println("Astart = ");
    }

    @Override
    void end() {
        System.out.println("Aend = ");
    }
}
