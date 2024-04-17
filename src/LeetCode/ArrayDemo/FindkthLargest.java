package LeetCode.ArrayDemo;

import java.util.*;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/19 4:28 下午
 * @Description:
 */
public class FindkthLargest {
    public static void main(String[] args) {
        int nums[] = {3,2,1,5,6,4};
//        System.out.println("findKth(nums,2) = " + findKth(nums,2));
        System.out.println("mopao(nums,2) = " + maxDui(nums,2));
    }

    public static int findKth(int nums[], int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static int mopao(int nums[], int k) {
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {
                if(nums[i]>nums[j]){
                    int arr = nums[i];
                    nums[i] = nums[j];
                    nums[j] = arr;
                }
            }
        }
        return nums[k-1];
    }

    public static int maxDui(int nums[], int k) {
        PriorityQueue<Integer> pa = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  o1-o2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if(pa.size()<k){
                pa.offer(nums[i]);
            }else {
                if(nums[i]>pa.peek()){
                    pa.poll();
                    pa.offer(nums[i]);
                }
            }

        }
        return pa.peek();
    }

        Random random = new Random();

        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, nums.length - k);
        }

        public int quickSelect(int[] a, int l, int r, int index) {
            int q = randomPartition(a, l, r);
            if (q == index) {
                return a[q];
            } else {
                return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
            }
        }

        public int randomPartition(int[] a, int l, int r) {
            int i = random.nextInt(r - l + 1) + l;
            swap(a, i, r);
            return partition(a, l, r);
        }

        public int partition(int[] a, int l, int r) {
            int x = a[r], i = l - 1;
            for (int j = l; j < r; ++j) {
                if (a[j] <= x) {
                    swap(a, ++i, j);
                }
            }
            swap(a, i + 1, r);
            return i + 1;
        }

        public void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

