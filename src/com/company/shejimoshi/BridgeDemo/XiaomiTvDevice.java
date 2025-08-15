package com.company.shejimoshi.BridgeDemo;

public class XiaomiTvDevice implements Device {

    @Override
    public void turnOn() {
        System.out.println("xiaomi");
    }

    @Override
    public void adjustVolume() {
        System.out.println("xiaomi");
    }
}
