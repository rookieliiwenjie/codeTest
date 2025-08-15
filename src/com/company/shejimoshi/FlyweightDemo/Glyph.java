package com.company.shejimoshi.FlyweightDemo;

// 抽象享元
public interface Glyph {
    void display(String extrinsicState);  // 外部状态（颜色/大小）由参数传入
}
