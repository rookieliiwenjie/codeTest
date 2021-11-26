package com.company.shejimoshi.templetepattern;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-11-10 16:03
 */
public abstract class BeanDemo {
    abstract void init();

    abstract void start();

    abstract void end();

    public final void go() {
        init();
        start();
        end();
    }


}
