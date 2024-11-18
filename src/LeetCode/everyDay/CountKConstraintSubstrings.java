package LeetCode.everyDay;

public class CountKConstraintSubstrings {

    public static void main(String[] args) {
//        String s= "0001111";
//        int k= 2;
//        int[][] queries= {{0, 6}};
        String s = "010101";
        int k = 1;
        int[][] queries = {{0, 5}, {1, 4}, {2, 3}};
        long[] longs = countKConstraintSubstringsHard(s, k, queries);
        for (long l : longs) {
            System.out.println(l);
        }
    }

    public static long[] countKConstraintSubstringsHard(String s, int k, int[][] queries) {
        long sum = 0;
        int count = s.length();
        char[] arr = s.toCharArray();
        long[] prxarr = new long[count + 1];
        for (int i = 0; i < count; i++) {
            int zSum = 0;
            int oneSum = 0;
            for (int j = 0; j <= i; j++) {
                for (int l = j; l <= i; l++) {
                    if (arr[l] == '0') {
                        zSum++;
                    }
                    if (arr[l] == '1') {
                        oneSum++;
                    }
                    if (zSum > k || oneSum > k) {
                        break;
                    }
                    sum++;
                }
            }
            prxarr[i + 1] = sum;

        }

        long[] result = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = prxarr[right + 1] - prxarr[left];
        }
        return result;
    }

    public static long[] countKConstraintSubstringsHard2(String s, int k, int[][] queries) {
        long sum = 0;
        int count = s.length();
        char[] arr = s.toCharArray();
        long[] prxarr = new long[count + 1];
        for (int i = 0; i < count; i++) {
            int zSum = 0;
            int oneSum = 0;
            for (int j = 0; j <= i; j++) {
                for (int l = j; l <= i; l++) {
                    if (arr[l] == '0') {
                        zSum++;
                    }
                    if (arr[l] == '1') {
                        oneSum++;
                    }
                    if (zSum > k || oneSum > k) {
                        break;
                    }
                    sum++;
                }
            }
            prxarr[i + 1] = sum;

        }

        long[] result = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = prxarr[right + 1] - prxarr[left];
        }
        return result;
    }

    public int countKConstraintSubstrings2(String s, int k) {
        int n = s.length(), res = 0;
        for (int i = 0; i < n; ++i) {
            int[] count = new int[2];
            for (int j = i; j < n; ++j) {
                count[s.charAt(j) - '0']++;
                if (count[0] > k && count[1] > k) {
                    break;
                }
                res++;
            }
        }
        return res;
    }

    public int countKConstraintSubstrings3(String s, int k) {
        int n = s.length(), res = 0;
        int left = 0;
        int right = left + 1;
        int[] arr = new int[2];
        while (right < n) {
            if (arr[0] > k && arr[1] > k) {
                if (arr[left] == '0') {
                    arr[0]--;
                }
                if (arr[left] == '1') {
                    arr[1]++;
                }
                left++;
                continue;
            }
            right++;
            res++;
        }


        return res;

    }


    public int countKConstraintSubstrings(String s, int k) {
        int sum = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int zSum = 0;
            int oneSum = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == '1') {
                    zSum++;
                }
                if (arr[j] == '0') {
                    oneSum++;
                }
                if (zSum > k && oneSum > k) {
                    break;
                }
                sum++;

            }
        }
        return sum;

    }
}
