package com.company.shejimoshi.FlyweightDemo;

public class Main {
    public static void main(String[] args) {
        GlyphFactory factory = new GlyphFactory();
        Glyph a = factory.getCharacter('a');
        a.display("\"红色,12px\"");
        Glyph a2 = factory.getCharacter('a');
        a2.display("蓝色,14px");  // 外部状态2
        System.out.println("a1和a2是同一对象: " + (a == a2));
    }
}
