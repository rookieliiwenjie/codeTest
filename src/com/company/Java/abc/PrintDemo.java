package com.company.Java.abc;

public class PrintDemo extends Thread {
    private String name;

    public PrintDemo(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " " + i);
        }
    }
}
