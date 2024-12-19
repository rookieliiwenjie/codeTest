package LeetCode.everyDay;

import java.util.*;
import java.util.stream.Collectors;

public class MinSetSize {
    /**
     * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
     * <p>
     * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [3,3,3,3,5,5,5,2,2,7]
     * 输出：2
     * 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
     * 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
     * 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
     * 示例 2：
     * <p>
     * 输入：arr = [7,7,7,7,7,7]
     * 输出：1
     * 解释：我们只能选择集合 {7}，结果数组为空。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= arr.length <= 105
     * arr.length 为偶数
     * 1 <= arr[i] <= 105
     *
     * @param arr
     * @return
     */
    public static void main(String[] args) {
        MinSetSize minSetSize = new MinSetSize();
        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        int res = minSetSize.minSetSize2(arr);
        System.out.println(res);
    }

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int compare = map.get(o2).compareTo(map.get(o1));
                if (compare == 0) {
                    return o2.compareTo(o1);
                }
                return compare;
            }
        });
        sortedMap.putAll(map);
        System.out.println(sortedMap);
        int res = 0;
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            sum += entry.getValue();
            res++;
            if (sum >= arr.length / 2) {
                break;
            }
        }
        return res;

    }

    /**
     * 思路与算法
     *
     * 在每一步操作中，我们需要选择一个数 x，并且删除数组 arr 中所有的 x。
     * 显然选择的数 x 在数组 arr 中出现的次数越多越好。因此我们可以统计数组 arr 中每个数出现的次数，
     * 并进行降序排序。在得到了排序的结果之后，我们依次选择这些数进行删除，直到删除了至少一半的数。
     *
     * 在统计数组 arr 中每个数出现的次数时，我们可以借助哈希映射（HashMap），
     * 对于其中的每个键值对，键表示数 x，值表示数 x 出现的次数。在统计结束后，
     * 我们只要取出哈希映射中的所有值进行降序排序即可。在进行删除时，我们实际上也只需要将删除的数的个数进行累加，直到累加的值达到数组 arr 长度的一半，而不需要真正地将数组 arr 中的数删除。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/reduce-array-size-to-the-half/solutions/130594/shu-zu-da-xiao-jian-ban-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param arr
     * @return
     */
    public int minSetSize2(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> occ = new ArrayList<>(freq.values());
        Collections.sort(occ, Collections.reverseOrder());
        int cnt = 0, ans = 0;
        for (int c : occ) {
            cnt += c;
            ans += 1;
            if (cnt * 2 >= arr.length) {
                break;
            }
        }
        return ans;
    }


}
