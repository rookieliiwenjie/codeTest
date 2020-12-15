package com.company.dem;

import java.util.LinkedList;
import java.util.Stack;

public class demo {
    public static void main(String args[]) {
        int x = 10%10;
        System.out.println("x = " + x);
        
        
        System.out.println(lengthOfLastWord("Hello World"));
    }

    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
