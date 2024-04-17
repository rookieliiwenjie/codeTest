package LeetCode.day01;

import java.util.Arrays;

/**
 * @Author rookie.li
 * @create 2020/12/2
 */
public class Candy {
    public static void main(String[] args) {

        int ratings[] = {1, 2, 87, 87, 87, 2, 1};
        int candy = candy(ratings);
        System.out.println("candy = " + candy);
    }

    public static int candy(int[] ratings) {
        /*int[] candy = new int[ratings.length];
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; --i) {
            if (ratings[i] < ratings[i - 1]) {
                candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
            }
        }*/
        //return Arrays.stream(candy).sum() + candy.length;
        int[] candy = new int[ratings.length];
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;

            }
        }
        for (int i = ratings.length - 1; i > 0; --i) {
            if (ratings[i] < ratings[i - 1]) {
                candy[i - 1] = Math.max(candy[i] + 1, candy[i-1]);
            }
        }
        return Arrays.stream(candy).sum() + candy.length;
    }

    public static int candy2(int[] ratings) {
        if (ratings.length < 2) {
            return ratings.length;
        }
        int[] candies = new int[ratings.length];

        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        int sum = 0;
        for (int i = ratings.length - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = java.lang.Math.max(candies[i], candies[i + 1] + 1);

            }
            sum += candies[i];
        }
        sum += candies[ratings.length - 1];
        return sum;
    }
}
