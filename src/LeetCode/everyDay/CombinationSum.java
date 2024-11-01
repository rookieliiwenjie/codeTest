package LeetCode.everyDay;

import java.util.*;

/**
 *
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int left = 0;
        int right = candidates.length - 1;
        List<List<Integer>> resultList = new ArrayList<>();

        while (left < right) {
            if (candidates[right] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[right]);
                resultList.add(list);
                right--;
            }
            if (target % candidates[left] == 0) {
                for (int i = 0; i < target / candidates[left]; i++) {
                    List<Integer> list = new ArrayList<>();
                    list.add(candidates[right]);
                    resultList.add(list);
                    right--;
                }
            }
            int num = candidates[left] + candidates[right];
            if (target > num) {
                right--;
            }
            if (target == num) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[right]);
                resultList.add(list);
                right--;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> list = combinationSum.combinationSum3(new int[]{2, 3, 6, 7}, 7);
        System.out.println(list.toString());
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : candidates) {
            if (num <= target) {
                set.add(num);
            }
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            int num = candidates[i];
            if (num > target) {
                break;
            }
            //一个数可以的情况
            if (target % num == 0) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < target / num; j++) {
                    list.add(num);
                }
                resultList.add(list);
            }
            if (num < target) {
                int binNum = candidates[0];
                int sum = num;
                List<Integer> waiList = new ArrayList<>();
                waiList.add(num);
                while (sum < target) {
                    if (set.contains(binNum)) {
                        waiList.add(binNum);
                        if (target == sum + binNum) {
                            resultList.add(waiList);
                        }
                        if ((target - sum) % binNum == 0) {
                            List<Integer> list = new ArrayList<>();
                            list.add(num);
                            for (int j = 0; j < (target - sum) % binNum; j++) {
                                list.add(binNum);
                            }
                            resultList.add(list);
                        }
                        sum += binNum;
                    }
                    binNum++;
                }

            }

        }
        return resultList;
    }


    public List<List<Integer>> combinationSum3(int[] candidates, int target) {

        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            int num = candidates[i];
            if (num > target) {
                break;
            }
            //一个数可以的情况
            if (target % num == 0) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < target / num; j++) {
                    list.add(num);
                }
                resultList.add(list);
            }
            if (num < target) {
                int sum = num;
                List<Integer> waiList = new ArrayList<>();
                waiList.add(num);
                for (int j = 0; j < candidates.length && sum < target; j++) {
                    int binNum = candidates[j];
                    waiList.add(binNum);
                    if (target == sum + binNum) {
                        resultList.add(waiList);
                        break;
                    }
                    if ((target - sum) % binNum == 0) {
                        List<Integer> list = new ArrayList<>();
                        for (int k = 0; k < (target - sum) % binNum; k++) {
                            list.add(binNum);
                        }
                        resultList.add(list);
                    }
                    sum += binNum;
                }


            }

        }
        return resultList;
    }


    /**
     * 递归版本
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum4(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(candidates);
        return resultList;
    }
}
