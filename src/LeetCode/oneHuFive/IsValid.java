package LeetCode.oneHuFive;

import java.util.*;

public class IsValid {
    public static void main(String[] args) {
        IsValid isValid = new IsValid();
//        boolean valid = isValid.isValid("()");
        String s = "]";

        System.out.println(isValid.isValid(s));
    }

    public boolean isValid(String s) {
        HashMap<Character, Character> fan = new HashMap();
        for (int i = 0; i < 3; i++) {
            fan.put('(', ')');
            fan.put('{', '}');
            fan.put('[', ']');
        }
        int slenght = s.length();
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < slenght; i++) {
            char c = s.charAt(i);
            if (fan.containsKey(c)) {
                characters.add(c);
            } else {
                if (characters.isEmpty() || !fan.get(characters.pop()).equals(c)) {
                    return false;
                }
            }
        }
        return characters.isEmpty();
    }

    public boolean isValid2(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
