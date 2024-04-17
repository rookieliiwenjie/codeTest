package LeetCode.oneHuFive;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(re.removeElement2(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        int numLength = 0;
        int index = 0;
        int endIndex = nums.length-1;
        while (index < nums.length && index <= endIndex) {
            if (nums[index] != val) {
                numLength++;
                index++;
            }else {
                int num = nums[index];
                nums[index] = nums[endIndex];
                nums[endIndex] = num;
                endIndex--;
            }
        }
        return numLength;
    }

    public int removeElement2(int[] nums, int val) {
        int n = nums.length;
        int left = 0;//慢指针
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
