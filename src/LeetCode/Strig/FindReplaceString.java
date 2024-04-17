package LeetCode.Strig;

import java.util.Arrays;
import java.util.Comparator;

public class FindReplaceString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int[][] indices2 = new int[indices.length][indices.length];
        for (int i = 0; i < indices.length; i++) {
            indices2[i][0] = indices[i];
            indices2[i][1] = i;
        }
        Arrays.sort(indices2, Comparator.comparingInt(o -> o[0]));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indices2.length; i++) {
            String source = sources[indices2[i][1]];
            int index = indices2[i][0];
            if (i == 0 && index != 0) {
                sb.append(s, 0, index);
            }
            int afterIndex = 0;
            if (i == indices.length - 1) {
                afterIndex = s.length();
            } else {
                afterIndex = indices2[i + 1][0];
            }
            int subLength = index + source.length();
            if (source.equals(s.substring(index, Math.min(subLength, s.length())))) {
                sb.append(targets[indices2[i][1]]);
                sb.append(s, index + source.length(), afterIndex);
            } else {
                sb.append(s, index, afterIndex);
            }
        }
        return sb.toString();
    }

    public String findRelaceString2(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int j = 0;
            while (j < indices.length) {
                int index = indices[j];
                String source = sources[j];
                String target = targets[j];
                if (index + source.length() <= s.length() && s.substring(index, index + source.length()).equals(source)) {
                    sb.append(target);
                    i += source.length();
                    break;
                }
                j++;
            }
            if (j == indices.length) {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "abcd";
//        String sources[] = {"ab", "ec"};
//        int indices[] = {0, 2};
//        String targets[] = {"eee", "ffff"};

        String s = "vmokgggqzp";
        String sources[] = {"kg", "ggq", "mo"};
        int indices[] = {3, 5, 1};
        String targets[] = {"s", "so", "bfr"};

//        String s = "abcde";
//        String sources[] = {"cdef", "bc"};
//        int indices[] = {2, 2};
//        String targets[] = {"f", "fe"};
        String replaceString = new FindReplaceString().findReplaceString(s, indices, sources, targets);
        System.out.println(replaceString);
    }

    public String findReplaceString4(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        String[] replaceStr = new String[n]; // 替换后的字符串
        int[] replaceLen = new int[n];    // 被替换的长度
        Arrays.fill(replaceLen, 1);     // 无需替换时 i+=1
        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            if (s.startsWith(sources[i], idx)) {
                replaceStr[idx] = targets[i];
                replaceLen[idx] = sources[i].length();
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i += replaceLen[i]) { // 无需替换时 i+=1
            if (replaceStr[i] == null) {
                ans.append(s.charAt(i));
            } else {
                ans.append(replaceStr[i]);
            }
        }
        return ans.toString();
    }
}
