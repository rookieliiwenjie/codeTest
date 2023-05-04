package com.company.shejimoshi.template;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/4 10:46 上午
 * @Description:
 */
public class GameTwo extends AbstrasGame{
    @Override
    void startPlay() {
        System.out.println("GameTwo startPlay");
    }

    @Override
    void init() {
        System.out.println("GameTwo init");
    }

    @Override
    void endPlay() {
        System.out.println("GameTwo endPlay");
    }
}
