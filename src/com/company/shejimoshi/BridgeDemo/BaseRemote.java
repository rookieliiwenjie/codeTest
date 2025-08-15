package com.company.shejimoshi.BridgeDemo;

public class BaseRemote extends RemoteContral {
    public BaseRemote(Device device) {
        super(device);
    }

    void turnOn() {
        device.turnOn();
    }

    ;

    void adjustVolume() {
        device.adjustVolume();
    }
}
