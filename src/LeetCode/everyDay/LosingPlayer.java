package LeetCode.everyDay;

public class LosingPlayer {
    public static void main(String[] args) {

        LosingPlayer losingPlayer = new LosingPlayer();
        String winner = losingPlayer.losingPlayer(2, 7);
        System.out.println(winner);
    }

    /**
     * 
     * @param x 75
     * @param y 10
     * @return
     */
    public String losingPlayer(int x, int y) {
        String[] userName = { "Alice", "Bob" };
        int index = 0;
        while (x > 0 && y > 3) {
            int ySum = (115 - 75) / 10;
            y -= ySum;
            x--;
            index++;
        }
        int winner = (index % 2) == 1 ? 0 : 1;
        return userName[winner];
    }
}
