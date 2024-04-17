package LeetCode.oneHuFive;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class Permute {
    public static void main(String[] args) {
        Permute permute = new Permute();
        int nums[] = {1, 2, 3};
        System.out.println(permute.permute(nums));
    }

    public List<List<Integer>> permute(int nums[]) {
        return getChildList(nums, 0);
    }

    /**
     * 1.放入结果的时机 ---
     * 2.递归的时机
     * 3.递归的终止条件
     * 4.递归的参数
     *
     * @param nums
     * @param index
     * @param list
     * @return
     */
    List<List<Integer>> getChildList(int nums[], int index) {
        if (index == nums.length) {
            return new ArrayList<>();
        }
        List<List<Integer>> newListList = new ArrayList<>();
        for (int i = index; i < nums.length; i++) {
            List<List<Integer>> childList = getChildList(nums, i + 1);
            if (childList.size() == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                newListList.add(list);
                continue;
            }
            for (int j = 0; j < childList.size(); j++) {
                List<Integer> newList = new ArrayList<>();
                newList.add(nums[i]);
                newList.addAll(childList.get(j));
                newListList.add(newList);
            }
        }
        return newListList;
    }

}
