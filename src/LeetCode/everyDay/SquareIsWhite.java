package LeetCode.everyDay;

public class SquareIsWhite {

    public static void main(String[] args) {
        SquareIsWhite qIsWhite = new SquareIsWhite();
        boolean a = qIsWhite.squareIsWhite("h3");
        System.out.println(a);
    }

    public boolean squareIsWhite(String coordinates) {
        int startIndex = 'a' - coordinates.charAt(0);
        int endIndex = '1' - coordinates.charAt(1);
        if (startIndex % 2 == 0) {
            return endIndex % 2 != 0;
        }
        return endIndex % 2 == 0;

    }

    public boolean squareIsWhite2(String coordinates) {
        return ((coordinates.charAt(0) - 'a' + 1) + (coordinates.charAt(1) - '0')) % 2 == 1;
    }

}
