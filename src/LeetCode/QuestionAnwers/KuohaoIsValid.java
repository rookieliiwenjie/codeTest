package LeetCode.QuestionAnwers;

import java.util.HashMap;
import java.util.Stack;

public class KuohaoIsValid {
    public boolean isValid(String s) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        hashMap.put('{', '}');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (hashMap.get(pop.charValue()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
}
