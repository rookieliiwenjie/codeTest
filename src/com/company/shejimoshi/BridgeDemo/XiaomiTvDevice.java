package com.company.shejimoshi.BridgeDemo;

public class SornTvDevice implements Device {

    @Override
    public void turnOn() {
        System.out.println("sorn");
    }

    @Override
    public void adjustVolume() {
        System.out.println("sorn");
    }
}
