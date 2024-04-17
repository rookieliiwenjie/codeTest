package LeetCode.ArrayDemo;

import java.util.Arrays;

public class FindContentChildren {

    public static void main(String[] args) {
        FindContentChildren findContentChildren = new FindContentChildren();
//            int []g = {1,2,3};
//            int []s = {1,1};

        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(findContentChildren.findContentChildren2(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int max = 0;
        int gSize = g.length;
        int sSize = s.length;
        int sIndex = 0;
        for (int i = 0; i < gSize; i++) {
            while (sIndex < sSize && s[sIndex] < g[i]) {
                sIndex++;
            }
            if (sIndex == sSize) {
                break;
            }
            max++;
            sIndex++;
        }
        return max;
    }

    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gSize = g.length;
        int sSize = s.length;
        int sIndex = 0;
        int gIndex = 0;
        while (sIndex < sSize && gIndex < gSize) {
            if (s[sIndex] >= g[gIndex]) {
                gIndex++;
            }
            sIndex++;
        }

        return gIndex;
    }
}
