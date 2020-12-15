package com.company.CountDownLatchDemo;

/**
 * Created by lwj32 on 2020/5/25.
 */
public enum CountryEnum {

    OEN(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "赵"),
    FOUR(4, "魏"),
    FIVE(5, "韩"),
    SIX(6, "秦");
    private int code;
    private String dec;

    CountryEnum(int code, String dec) {
        this.code = code;
        this.dec = dec;

    }

    public String getDec() {
        return this.dec;
    }

    public int getCode() {
        return this.code;
    }

    public static String CountryForEach(int index) {
        for (CountryEnum el : CountryEnum.values()) {
            if (index == el.code) {
                return el.dec;
            }
        }
        return null;
    }

}
