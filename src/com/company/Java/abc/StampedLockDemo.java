package com.company.Java.abc;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    static StampedLock stampedLock = new StampedLock();

    public static void main(String[] args) {
        stampedLock.readLock();
        stampedLock.unlockRead(1);
    }
}
