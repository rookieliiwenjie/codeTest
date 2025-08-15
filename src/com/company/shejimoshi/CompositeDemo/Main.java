package com.company.shejimoshi.CompositeDemo;

public class Main {
    public static void main(String[] args) {
        File file = new File("A");
        File fileB = new File("A");
        Directory directory = new Directory("Adir");
        directory.addComponent(file);
        directory.addComponent(fileB);
        directory.displayInfo();
        Directory directoryRoot = new Directory("Root");
        directoryRoot.addComponent(directory);
        directoryRoot.displayInfo();
    }
}
