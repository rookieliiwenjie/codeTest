package com.company.shejimoshi.BridgeDemo;
// 抽象部分 - 执行类
public abstract class RemoteContral {
    protected Device device;

    public RemoteContral(Device device) {
        this.device = device;
    }

    abstract void turnOn();

    abstract void adjustVolume();
}
