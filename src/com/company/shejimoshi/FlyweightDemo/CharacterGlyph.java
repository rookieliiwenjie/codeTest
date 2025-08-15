package com.company.shejimoshi.FlyweightDemo;

// 具体享元（字符对象）
public class CharacterGlyph implements Glyph {
    private char intrinsicState;

    public CharacterGlyph(char intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void display(String style) {
        System.out.println("字符: " + intrinsicState + " 样式: " + style);
    }

    @Override
    public String toString() {
        return "CharacterGlyph{" +
                "intrinsicState=" + intrinsicState +
                '}';
    }
}
