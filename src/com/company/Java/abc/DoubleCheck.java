package com.company.Java.abc;

public class DoubleCheck {
    private static volatile DoubleCheck instance;

    /**
     * double check
     * @return
     */
    public DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (DoubleCheck.class) {
                if (instance == null) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}
