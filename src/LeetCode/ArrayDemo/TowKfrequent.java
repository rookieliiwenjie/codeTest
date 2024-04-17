package LeetCode.ArrayDemo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/16 5:01 下午
 * @Description:
 */
public class TowKfrequent {
    /**
     * 1.对于k如何排序如何取 ---使用队列（个人评价有点low，但我也想不到更好的方式，hashmap和其他也很low）
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        int arr[] = new int[k];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        ConcurrentHashMap<Integer, Integer> sortHashmap = new ConcurrentHashMap<>(k);
        for (Integer key : hashMap.keySet()) {
            if (sortHashmap.size() < k) {
                sortHashmap.put(key, hashMap.get(key));
                continue;
            }
            Integer minKey = sortHashmap.keySet().stream().findFirst().get();
            for (Integer newKey : sortHashmap.keySet()) {
                if(sortHashmap.get(newKey)<sortHashmap.get(minKey)){
                    minKey = newKey;
                }
            }
            if (sortHashmap.get(minKey) < hashMap.get(key)) {
                sortHashmap.remove(minKey);
                sortHashmap.put(key, hashMap.get(key));
            }
        }
        int index = 0;
        for (Integer key : sortHashmap.keySet()) {
            arr[index] = key;
            index++;
        }
        return arr;
    }


    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数 优先队列
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

    public static void main(String[] args) {
        int [] nums = {4,1,-1,2,-1,2,3};
        int [] nums1 = {2,3,4,1,4,0,4,-1,-2,-1};
        int k = 2;
        topKFrequent(nums1,k);
    }
}
