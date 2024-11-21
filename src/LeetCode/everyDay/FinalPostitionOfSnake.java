package LeetCode.everyDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FinalPostitionOfSnake {

    public static void main(String[] args) {
        // int n= 2;
        // List<String> commands = new ArrayList<>();
        // commands.add("RIGHT");
        // commands.add("DOWN");
        int n = 2;
        List<String> commands = new ArrayList<>();
        commands.add("RIGHT");
        commands.add("LEFT");
        FinalPostitionOfSnake finalPostitionOfSnake = new FinalPostitionOfSnake();
        System.out.println(finalPostitionOfSnake.finalPostitionOfSnake2(n, commands));
    }

    public int finalPostitionOfSnake(int n, List<String> commands) {
        int endIndex = 0;
        // up right Down Left
        HashMap<String, int[]> hashMap = new HashMap<>();
        hashMap.put("UP", new int[] { -1, 0 });
        hashMap.put("DOWN", new int[] { 1, 0 });
        hashMap.put("RIGHT", new int[] { 0, 1 });
        hashMap.put("LEFT", new int[] { 0, -1 });
        int x = 0;
        int y = 0;
        for (String commString : commands) {
            int turn[] = hashMap.get(commString);
            x += turn[0];
            y += turn[1];
        }
        endIndex = x * n + y;
        return endIndex;
    }

    // simple
    public int finalPostitionOfSnake2(int n, List<String> commands) {
        int endIndex = 0;
        // up right Down Left
        for (String commString : commands) {
            if (commString.charAt(0) == 'U') {
                endIndex = endIndex - n;

            } else if (commString.charAt(0) == 'D') {
                endIndex = endIndex + n;
            } else if (commString.charAt(0) == 'L') {
                endIndex = endIndex - 1;
            } else {
                endIndex++;
            }
        }
        return endIndex;
    }

}
