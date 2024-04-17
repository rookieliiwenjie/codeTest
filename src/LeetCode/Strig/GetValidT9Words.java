package LeetCode.Strig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetValidT9Words {
    public static void main(String[] args) {
        String num = "8733";
        String words[] = {"tree", "used"};
        GetValidT9Words getValidT9Words = new GetValidT9Words();
        getValidT9Words.getValidT9Words(num, words);
    }

    public List<String> getValidT9Words(String num, String[] words) {
        Character[][] arr = {{'_'}, {'!', '@', '#'}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        List<List<Character>> charList = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            List<Character> characters = new ArrayList<>(Arrays.asList(arr[j]));
            charList.add(characters);
        }
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (int j = 0; j < words[i].length(); j++) {
                int index = num.charAt(j) - '0';
                List<Character> characters = charList.get(index);
                if(!characters.contains(words[i].charAt(j))){
                    flag = false;
                    break;
                }
            }
            if(flag){
                strings.add(words[i]);
            }
        }
        return strings;
    }
}
