package LeetCode.everyDay;

public class DistributeCandies {

    public static void main(String[] args) {
        DistributeCandies distributeCandies = new DistributeCandies();
        int candies = 10;
        int num_people = 3;
        int[] result = distributeCandies.distributeCandies(candies, num_people);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] distributeCandies(int candies, int num_people) {
        int[] candyPeople = new int[num_people];
        int pe = 0;
        int n = 1;
        while (candies > 0) {
            if (candies - n <= 0) {
                candyPeople[pe % num_people] += candies;
            } else {
                candyPeople[pe % num_people] += n;
            }
            candies -= n;
            n++;
            pe++;
        }
        return candyPeople;
    }

    /**
     * 2.0版本 有没有其他方式呢？
     * n*(n+1)/2
     * @param candies
     * @param num_people
     * @return
     */
    public int[] distributeCandies2(int candies, int num_people) {
        int[] candyPeople = new int[num_people];

        return candyPeople;
    }
}
