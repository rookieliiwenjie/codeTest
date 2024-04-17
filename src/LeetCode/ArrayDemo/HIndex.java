package LeetCode.ArrayDemo;

public class HIndex {

    public static void main(String[] args) {
        // int ci[] = {0, 1, 3, 5, 6};

        //int ci[] = {1, 2, 100};
        int ci[] = {0};
        //int ci[] = {100};
        System.out.println(hIndex2(ci));
    }

    //对数时间复杂度
    public static int hIndex(int[] citations) {
        //h代表h篇最少h次饮用
        //第一个就是h
        //dih篇
        int leght = citations.length;
        int left = 0, right = citations.length;
        while (left <= right) {
            int index = left + (right - left) / 2;
            if ((leght - index) < citations[index]) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return leght - left;
    }

    public static int hIndex2(int[] citations) {
        //h代表h篇最少h次饮用
        //第一个就是h
        int n = citations.length;
        int hinex = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] <= (n - i)) {
                hinex = i;
            }
        }
        return n - hinex;
    }


}
