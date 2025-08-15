package com.company.shejimoshi.AdapterDemo.AdpaterNew;

public class Main {
    public static void main(String[] args) {
        Shape shape = new AdpaterShpe(new LegacyRectangle());
        shape.draw(1,1,1,1);
    }
}
