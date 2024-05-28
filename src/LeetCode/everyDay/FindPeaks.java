package LeetCode.everyDay;

import java.util.ArrayList;
import java.util.List;

public class FindPeaks {

    public static void main(String[] args) {
        FindPeaks findPeaks = new FindPeaks();
//        int[] mountain = {2, 4, 4};
        int[] mountain = {1, 4, 3, 8, 5};
        List<Integer> peaks = findPeaks.findPeaks(mountain);
        System.out.println(peaks.toString());
    }

    public List<Integer> findPeaks(int mountain[]) {
        List<Integer> mountainList = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i - 1] < mountain[i] && mountain[i + 1] < mountain[i]) {
                mountainList.add(i);
            }
        }
        return mountainList;
    }
}
