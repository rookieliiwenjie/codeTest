package com.company.javaBase;

public class StringBufferAndStringBuilder {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello");
        stringBuffer.append("world");
        System.out.println(stringBuffer.toString());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello");
        stringBuilder.append("world");
        System.out.println(stringBuilder.toString());
    }

}
