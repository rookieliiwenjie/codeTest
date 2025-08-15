package com.company.shejimoshi.BridgeDemo;

public class Main {
    public static void main(String[] args) {
        RemoteContral remoteContral = new BaseRemote(new SornTvDevice());
        remoteContral.turnOn();
        remoteContral.adjustVolume();
    }
}
