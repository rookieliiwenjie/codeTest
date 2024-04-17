package LeetCode.Strig;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/2 1:12 上午
 * @Description:
 */
public class VowelStrings {
    public static void main(String[] args) {
        String wores[]={"aba","bcb","ece","aa","e"};
        int [][] qu = {{0,2},{1,4},{1,1}};
        vowelStrings(wores,qu);
    }
    public static boolean isVowelString(String word) {
        return isVowelLetter(word.charAt(0)) && isVowelLetter(word.charAt(word.length() - 1));
    }

    public static boolean isVowelLetter(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

//    public static int[] vowelStrings(String[] words, int[][] queries) {
//        int arr[] = new int[words.length+1];
//        for (int i = 0; i < words.length; i++) {
//            if (isVowelString(words[i])) {
//                arr[i + 1] = arr[i] + 1;
//            }
//        }
//        int []retureArr = new int[queries.length];
//        for (int j = 0;j<queries.length;j++) {
//            int left = queries[j][0];
//            int right = queries[j][1];
//            int num = 0;
//            for (int i = left; i <=right; i++) {
//                num+=arr[i];
//            }
//            retureArr[j] = num;
//        }
//        return retureArr;
//    }
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int arr[] = new int[words.length+1];
        for (int i = 0; i < words.length; i++) {
            if (isVowelString(words[i])) {
                arr[i + 1] = arr[i] + 1;
            }
        }
        int []retureArr = new int[queries.length];
        for (int j = 0;j<queries.length;j++) {
            int left = queries[j][0];
            int right = queries[j][1];
            retureArr[j] = arr[right+1]-arr[left];
        }
        return retureArr;
    }
}
