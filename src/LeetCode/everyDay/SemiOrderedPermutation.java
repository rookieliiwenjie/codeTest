package LeetCode.everyDay;

public class SemiOrderedPermutation {

    public static void main(String[] args) {
        SemiOrderedPermutation semiOrderedPermutation = new SemiOrderedPermutation();
        // int nums[] = { 2, 4, 1, 3 };
        int nums[] = { 2, 1, 4, 3 };
        System.out.println(semiOrderedPermutation.semiOrderEdPermutation(nums));

    }

    public int semiOrderEdPermutation(int nums[]) {
        int n = nums.length;
        int sumMove = 0;
        if (nums[0] == 1 && nums[n - 1] == 0) {
            return sumMove;
        }
        int one = -1;
        int nindex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                one = i;
            }
            if (nums[i] == n) {
                nindex = i;
            }
            if (one != -1 && nindex != -1) {
                break;
            }
        }
        sumMove = one + n - 1 - nindex;
        return one > nindex ? sumMove - 1 : sumMove;
    }
}
