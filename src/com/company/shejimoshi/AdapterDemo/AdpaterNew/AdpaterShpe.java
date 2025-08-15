package com.company.shejimoshi.AdapterDemo.AdpaterNew;

/**
 * 适配器类
 */
public class AdpaterShpe implements Shape {
    LegacyRectangle legacyRectangle;

    @Override
    public void draw(int x, int y, int width, int height) {
        int x1 = x;
        int y1 = y;
        int x2 = x + width;
        int y2 = y + height;
        legacyRectangle.display(x1, y1, x2, y2);
    }

    public AdpaterShpe(LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }
}
