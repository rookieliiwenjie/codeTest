package LeetCode.everyDay;

public class NumberOfAlternatingGroups {

    public int numberOfAlternatingGroups(int colors[]) {
        int res = 0;
        for (int i = 0; i < colors.length; i++) {
            int left = 0;
            int right = 0;
            if (i == 0) {
                left = colors.length - 1;
                right = i + 1;
            } else if (i == colors.length - 1) {
                left = i - 1;
                right = 0;
            } else {
                left = i - 1;
                right = i + 1;
            }
            if (colors[i] != colors[left] && colors[i] != colors[right]) {
                res++;
            }
        }
        return res;
    }

    public int numberOfAlternatingGroups2(int[] colors) {
        int n = colors.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[(i - 1 + n) % n] && colors[i] != colors[(i + 1) % n]) {
                res += 1;
            }
        }
        return res;
    }

}
