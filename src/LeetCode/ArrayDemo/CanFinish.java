package LeetCode.ArrayDemo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CanFinish {
    public static void main(String[] args) {
        CanFinish canFinish = new CanFinish();
        int numCoures = 2;
        int[][] preequsites = {{1, 0}, {0, 1}};
//        int numCoures = 1;
//        int[][] preequsites = {};
//        int numCoures = 5;
//        int[][] preequsites = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        boolean b = canFinish.canFinish(numCoures, preequsites);
        System.out.println(b);

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ConcurrentHashMap<Integer, List<Integer>> hashMap = new ConcurrentHashMap<>();
        if (prerequisites.length == 0) {
            return true;
        }
        for (int[] pre : prerequisites) {
            if (hashMap.containsKey(pre[1])) {
                hashMap.get(pre[1]).add(pre[0]);
            } else {
                List<Integer> list = new CopyOnWriteArrayList<>();
                list.add(pre[0]);
                hashMap.put(pre[1], list);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> value : hashMap.entrySet()) {
            List<Integer> value1 = value.getValue();
//            if(){
//
//            }
        }
        return set.size() >= numCourses;
    }
}
