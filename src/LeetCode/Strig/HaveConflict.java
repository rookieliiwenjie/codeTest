package LeetCode.Strig;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/17 10:09 上午
 * @Description:
 */
public class HaveConflict {
    /**
     * 1、如何高效切割
     * 2、如何字符和数字对比 应该是用了字符的特效。
     *
     * @return
     */
    public static void main(String[] args) {

        String[] event2 = {"08:30", "09:00"};
        String[] event1 = {"07:30", "09:30"};
        System.out.println("event2 = " + haveConflictMy(event1, event2));
    }

    public static boolean haveConflict(String[] event1, String[] event2) {
        // a < b  那么 <0
      //       e11 > e20   e21> e10
             //e10 < e11  e20 < e21

        //       13                 11
//        return !(event1[1].compareTo(event2[0]) < 0 ||
                  //   12            //10
//                event2[1].compareTo(event1[0]) < 0);

        return event1[0].compareTo(event2[1]) < 0
         && event1[1].compareTo(event2[0]) >=0 ;
    }

    public static boolean haveConflictMy(String[] event1, String[] event2) {
        // a > b  那么 >0
        return (event1[0].compareTo(event2[0]) >= 0 && event1[0].compareTo(event2[1]) <= 0)
                || (event2[0].compareTo(event1[0]) >= 0 && event2[0].compareTo(event1[1]) <= 0);
    }
}
