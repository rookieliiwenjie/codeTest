package com.company.Java.objectpool;

public class StringUtils {
    public static boolean isEmpty(String tableName) {
        return tableName == null || tableName.length() == 0;
    }

    public static boolean equals(String tableName, String wareWare) {
        return tableName.equals(wareWare);
    }

    public static String[] split(String tableName, String s) {
        return tableName.split(s);
    }
}
