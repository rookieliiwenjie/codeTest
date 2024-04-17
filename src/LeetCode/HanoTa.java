package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HanoTa {
    public static void main(String[] args) {
        HanoTa hanoTa = new HanoTa();
        List<Integer> A = new ArrayList<>(Arrays.asList(5,4,2,1,0));
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        hanoTa.hanota(A, B, C);
        System.out.println(C);
    }

    /**
     * 比它大的盘子不能放在比它小的盘子上面
     *
     * @param A
     * @param B
     * @param C
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        // A 476 B 477 478
        move(A.size(), A, B, C);
    }

    public void move(int size, List<Integer> start, List<Integer> avla, List<Integer> target) {
        if (size == 1) {
            target.add(start.remove(start.size() - 1));
            return;
        }

        //将A上面的size-1个盘子借助C移动到B
        move(size - 1, start, target, avla);
        //将A上的最后一个盘子移动到C
        target.add(start.remove(start.size() - 1));
        //将B上的size-1个盘子借助A移动到C
        move(size - 1, avla, start, target);

    }
}
