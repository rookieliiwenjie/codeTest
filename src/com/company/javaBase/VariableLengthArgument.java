package com.company.javaBase;

public class VariableLengthArgument {
    public static void main(String[] args) {

    }
    public static void p(String ... args){
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
