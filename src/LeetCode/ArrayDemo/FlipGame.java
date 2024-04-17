package LeetCode.ArrayDemo;

import java.util.*;

public class FlipGame {
    public static void main(String[] args) {
        int fronts[] = {1, 2, 4, 4, 7};
        int backs[] = {1, 3, 4, 1, 3};

//        int fronts[] = {1};
//        int backs[] = {2};
        System.out.println(new FlipGame().flipGame3(fronts, backs));
    }

    public int flipGame(int[] fronts, int[] backs) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < fronts.length; i++) {
            if (hashMap.containsKey(fronts[i])) {
                hashMap.get(fronts[i]).add(i);
            } else {
                List<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                hashMap.put(fronts[i], arrayList);

            }
        }
        int min = 0;
        for (int i = 0; i < backs.length; i++) {
            if (!hashMap.containsKey(backs[i])) {
                min = min == 0 ? backs[i] : Math.min(min, backs[i]);
            } else {
                List<Integer> integers = hashMap.get(backs[i]);
                if (integers.size() == 1 && integers.get(0) == i) {
                    min = min == 0 ? backs[i] : Math.min(min, backs[i]);
                    continue;
                }
            }
        }
        return min;
    }

    public int flipGame2(int[] fronts, int[] backs) {
        Set<Integer> integerHashSet = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            integerHashSet.add(fronts[i]);
        }
        int min = -1;
        for (int i = 0; i < backs.length; i++) {
            if (!integerHashSet.contains(backs[i])) {
                min = min == -1 ? i : (backs[min] > backs[i]) ? i : min;
            }
        }
        return min != -1 ? backs[min] : 0;
    }

    public int flipGame3(int[] fronts, int[] backs) {
        Set<Integer> integerHashSet = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                integerHashSet.add(fronts[i]);
            }
        }
        int min = 3000;
        for (int i = 0; i < backs.length; i++) {
            int fron = fronts[i];
            int back = backs[i];
            if (min > fron && !integerHashSet.contains(fron)) {
                min = fron;
            }
            if (min > back && !integerHashSet.contains(back)) {
                min = back;
            }
        }
        return min % 3000;
    }
    public int flipGame4(int[] fronts, int[] backs) {
        Set<Integer> integerHashSet = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                integerHashSet.add(fronts[i]);
            }
        }
        int min = 3000;
        for (int i = 0; i < fronts.length; i++) {
            int fron = fronts[i];
            if (min > fron && !integerHashSet.contains(fron)) {
                min = fron;
            }
        }
        for (int j = 0; j < backs.length; j++) {
            int back = backs[j];
            if (min > back && !integerHashSet.contains(back)) {
                min = back;
            }
        }
        return min % 3000;
    }


    public int flipgame6(int[] fronts, int[] backs) {
        Set<Integer> same = new HashSet();
        for (int i = 0; i < fronts.length; ++i) {
            if (fronts[i] == backs[i]) {
                same.add(fronts[i]);
            }
        }
        int res = 3000;
        for (int x : fronts) {
            if (x < res && !same.contains(x)){
                res = x;
            }
        }
        for (int x : backs) {
            if (x < res && !same.contains(x)) {
                res = x;
            }
        }
        return res % 3000;
    }
}
