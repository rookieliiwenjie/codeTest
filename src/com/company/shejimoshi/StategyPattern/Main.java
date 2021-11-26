package com.company.shejimoshi.StategyPattern;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-11-10 16:01
 */
public class Main {
    public static void main(String[] args) {
        Centext centext = new Centext(new EmailRule());
        String s = centext.execRule();
        System.out.println("s = " + s);
    }
}
