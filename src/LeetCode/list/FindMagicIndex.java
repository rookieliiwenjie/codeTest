package LeetCode.list;

public class FindMagicIndex {

    public int findMagicIndex(int[] nums) {
        int num = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                num = i;
                break;
            }
        }
        return num;

    }

    /**
     * 二分剪枝
     *
     * @param nums
     * @return
     */
    public int findMagicIndex2(int[] nums) {

        return getAnswer(0, nums.length - 1, nums);
    }

    public int getAnswer(int left, int right, int nums[]) {
        if (left > right) {
            return -1;
        }
        int mod = left + (right - left) / 2;
        if (mod == nums[mod]) {
            return mod;
        }

        if (mod > nums[mod]) {
            int num = getAnswer(mod, right, nums);
            if (num != -1) {
                return num;
            }
        } else {
            int num = getAnswer(left, mod, nums);
            if (num != -1) {
                return num;
            }
        }
        return -1;
    }

    public int getAnswer2(int left, int right, int nums[]) {
        if (left > right) {
            return -1;
        }
        int mod = left + (right - left) / 2;
        int leftAn = getAnswer2(left, mod - 1, nums);
        if (leftAn != -1) {
            return leftAn;
        } else if (nums[mod] == mod) {
            return mod;
        }
        return getAnswer2(mod + 1, right, nums);
    }


    public static void main(String[] args) {
        FindMagicIndex findMagicIndex = new FindMagicIndex();
        int nums[] = {0, 0, 2};
        findMagicIndex.findMagicIndex2(nums);
    }


}
