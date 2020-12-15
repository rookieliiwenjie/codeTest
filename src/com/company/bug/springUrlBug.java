package com.company.bug;

/**
 * @Author rookie.li
 * @create 2020/11/10
 */
public class springUrlBug {
    public static void main(String[] args) {
        /**
         * 
         */
        System.out.println(" /api\u200B/message\u200B/list\u200B/1.0?ttid=123&scope=test" );
        String object = "/api\u200B/message\u200B/list\u200B/1.0?ttid=123&scope=test";
        Object oject2 = object;
        System.out.println("oject2 = " + oject2);
        System.out.println("object = " + object);
    }
}
