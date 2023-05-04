package com.company.shejimoshi.template;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/4 10:46 上午
 * @Description:
 */
public class GameOne extends AbstrasGame{
    @Override
    void startPlay() {
        System.out.println("GameOne startPlay");
    }

    @Override
    void init() {
        System.out.println("GameOne init");
    }

    @Override
    void endPlay() {
        System.out.println("GameOne endPlay");
    }
}
