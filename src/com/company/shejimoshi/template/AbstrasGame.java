package com.company.shejimoshi.template;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/4 10:45 上午
 * @Description:
 */
public abstract class AbstrasGame {
    abstract void startPlay();
    abstract void init();
    abstract void endPlay();
    public void play(){
        startPlay();
        init();
        endPlay();
    }

}
