package LeetCode.everyDay;

import javafx.util.Pair;

import java.util.*;

/**
 * 设计一个支持下述操作的食物评分系统：
 * <p>
 * 修改 系统中列出的某种食物的评分。
 * 返回系统中某一类烹饪方式下评分最高的食物。
 * 实现 FoodRatings 类：
 * <p>
 * FoodRatings(String[] foods, String[] cuisines, int[] ratings) 初始化系统。食物由 foods、cuisines 和 ratings 描述，长度均为 n 。
 * foods[i] 是第 i 种食物的名字。
 * cuisines[i] 是第 i 种食物的烹饪方式。
 * ratings[i] 是第 i 种食物的最初评分。
 * void changeRating(String food, int newRating) 修改名字为 food 的食物的评分。
 * String highestRated(String cuisine) 返回指定烹饪方式 cuisine 下评分最高的食物的名字。如果存在并列，返回 字典序较小 的名字。
 * 注意，字符串 x 的字典序比字符串 y 更小的前提是：x 在字典中出现的位置在 y 之前，也就是说，要么 x 是 y 的前缀，
 * 或者在满足 x[i] != y[i] 的第一个位置 i 处，x[i] 在字母表中出现的位置在 y[i] 之前。
 * <p>
 * 1 <= n <= 2 * 104
 * n == foods.length == cuisines.length == ratings.length
 * 1 <= foods[i].length, cuisines[i].length <= 10
 * foods[i]、cuisines[i] 由小写英文字母组成
 * 1 <= ratings[i] <= 108
 * foods 中的所有字符串 互不相同
 * 在对 changeRating 的所有调用中，food 是系统中食物的名字。
 * 在对 highestRated 的所有调用中，cuisine 是系统中 至少一种 食物的烹饪方式。
 * 最多调用 changeRating 和 highestRated 总计 2 * 104 次
 */
public class FoodRatings {
    /**
     * foods:["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
     * cuisines:[[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"],
     * ["korean", "japanese", "japanese", "greek", "japanese", "korean"],
     * [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
     * 输出
     * [null, "kimchi", "ramen", null, "sushi", null, "ramen"]
     *
     * @param foods
     * @param cuisines
     * @param ratings
     */
    //key : cuisine value : TreeMap<food,rating>
    HashMap<String, TreeSet<Pair<Integer, String>>> cuisineMap;
    //key : food value : cuisine
    HashMap<String, Pair<Integer, String>> foodMap;



    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineMap = new HashMap<>();
        foodMap = new HashMap<>();
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            Integer rating = ratings[i];
            foodMap.put(foods[i], new Pair<>(rating, cuisine));
            cuisineMap.computeIfAbsent(cuisine, k -> new TreeSet<>((a, b) -> {
                if (!a.getKey().equals(b.getKey())) {
                    return a.getKey() - b.getKey();
                }
                return b.getValue().compareTo(a.getValue());
            })).add(new Pair<>(rating, food));

        }
    }
    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).last().getValue();
    }



    //changeRating(String food, int newRating) 修改名字为 food 的食物的评分。
    public void changeRating(String food, int newRating) {
        Pair<Integer, String> integerStringPair = foodMap.get(food);
        String conu = integerStringPair.getValue();
        Integer oldRat = integerStringPair.getKey();
        foodMap.put(food,new Pair<>(newRating,integerStringPair.getValue()));
        cuisineMap.get(conu).remove(new Pair<>(oldRat,food));
        cuisineMap.get(conu).add(new Pair<>(newRating,food));
    }

    public static void main(String[] args) {
        String foods[] = new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String cuisines[] = new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int ratings[] = new int[]{9, 12, 8, 15, 14, 7};

        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);
        //kimchi
        System.out.println(foodRatings.highestRated("korean"));
        //ramen
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("sushi", 16);
        //sushi
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("ramen", 16);
        //ramen
        System.out.println(foodRatings.highestRated("japanese"));
    }

    // String highestRated(String cuisine) 返回指定烹饪方式 cuisine 下评分最高的食物的名字。如果存在并列，返回 字典序较小 的名字。

    class FoodRatings4 {
        private final Map<String, Pair<Integer, String>> foodMap = new HashMap<>();
        private final Map<String, TreeSet<Pair<Integer, String>>> cuisineMap = new HashMap<>();

        public FoodRatings4(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                String food = foods[i];
                String cuisine = cuisines[i];
                int rating = ratings[i];
                foodMap.put(food, new Pair<>(rating, cuisine));
                cuisineMap.computeIfAbsent(cuisine, k -> new TreeSet<>((a, b) ->
                        !Objects.equals(a.getKey(), b.getKey()) ? b.getKey() - a.getKey() : a.getValue().compareTo(b.getValue())
                )).add(new Pair<>(rating, food));
            }
        }

        public void changeRating(String food, int newRating) {
            Pair<Integer, String> p = foodMap.get(food);
            TreeSet<Pair<Integer, String>> st = cuisineMap.get(p.getValue());
            st.remove(new Pair<>(p.getKey(), food)); // 移除旧数据
            st.add(new Pair<>(newRating, food)); // 添加新数据
            foodMap.put(food, new Pair<>(newRating, p.getValue()));
        }

        public String highestRated(String cuisine) {
            return cuisineMap.get(cuisine).first().getValue();
        }
    }
    class FoodRatings2 {

        private Map<String, Pair<Integer, String>> foodMap;
        private Map<String, TreeSet<Pair<Integer, String>>> ratingMap;
        private int n;

        public FoodRatings2(String[] foods, String[] cuisines, int[] ratings) {
            n = foods.length;
            foodMap = new HashMap<>();
            ratingMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String food = foods[i];
                String cuisine = cuisines[i];
                int rating = ratings[i];
                foodMap.put(food, new Pair<>(rating, cuisine));
                ratingMap.computeIfAbsent(cuisine, k -> new TreeSet<>((a, b) -> {
                    if (!a.getKey().equals(b.getKey())) {
                        return a.getKey() - b.getKey();
                    }
                    return a.getValue().compareTo(b.getValue());
                })).add(new Pair<>(n - rating, food));
            }
        }

        public void changeRating(String food, int newRating) {
            Pair<Integer, String> pair = foodMap.get(food);
            int oldRating = pair.getKey();
            String cuisine = pair.getValue();
            ratingMap.get(cuisine).remove(new Pair<>(n - oldRating, food));
            ratingMap.get(cuisine).add(new Pair<>(n - newRating, food));
            foodMap.put(food, new Pair<>(newRating, cuisine));
        }

        public String highestRated(String cuisine) {
            return ratingMap.get(cuisine).first().getValue();
        }
    }


    class FoodRatings3 {
        private Map<String, Pair<Integer, String>> foodMap;
        private Map<String, PriorityQueue<Pair<Integer, String>>> ratingMap;
        private int n;

        public FoodRatings3(String[] foods, String[] cuisines, int[] ratings) {
            n = foods.length;
            foodMap = new HashMap<>();
            ratingMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String food = foods[i];
                String cuisine = cuisines[i];
                int rating = ratings[i];
                foodMap.put(food, new Pair<>(rating, cuisine));
                ratingMap.computeIfAbsent(cuisine, k -> new PriorityQueue<>((a, b) -> {
                    if (!a.getKey().equals(b.getKey())) {
                        return a.getKey() - b.getKey();
                    }
                    return a.getValue().compareTo(b.getValue());
                })).add(new Pair<>(n - rating, food));
            }
        }

        public void changeRating(String food, int newRating) {
            Pair<Integer, String> pair = foodMap.get(food);
            String cuisine = pair.getValue();
            ratingMap.get(cuisine).add(new Pair<>(n - newRating, food));
            foodMap.put(food, new Pair<>(newRating, cuisine));
        }

        public String highestRated(String cuisine) {
            PriorityQueue<Pair<Integer, String>> q = ratingMap.get(cuisine);
            while (!q.isEmpty()) {
                Pair<Integer, String> top = q.peek();
                String food = top.getValue();
                if (n - top.getKey() == foodMap.get(food).getKey()) {
                    return food;
                }
                q.poll();
            }
            return "";
        }
    }

}
