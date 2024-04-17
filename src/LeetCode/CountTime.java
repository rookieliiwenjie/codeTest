package LeetCode;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/9 10:05 上午
 * @Description:
 */
public class CountTime {
    public static void main(String[] args) {
        String s = "0?:0?";
        String s2 = "??:??";
        String s3 = "?3:00";
        String s4 = "2?:??";
        String s5 = "?4:22";
//        int count = countTime(s);
//        System.out.println("count = " + count);
//        System.out.println("s2 = " + countTime(s2));
        System.out.println("s3 = " + countTime(s5));
    }

    public static int countTime(String time) {
        int count = 1;
        int arr[] = new int[]{3, 10, 0, 6, 10};
        char firstIndex = time.charAt(0);
        for (int i = 1; i < time.length(); i++) {
            if (time.charAt(i) == '?' && i == 1 ) {
                if (firstIndex == '?') {
                    count = 24;
                } else if(Character.getNumericValue(firstIndex) ==2) {
                    count = 4 ;
                }else{
                    count = arr[i];
                }
            } else if (time.charAt(i) != '?' && i == 1) {
                if (firstIndex == '?') {
                    if ( Character.getNumericValue(time.charAt(i)) >= 4) {
                        count = 2 ;
                    } else {
                        count = arr[0];
                    }
                }

            } else if(time.charAt(i) == '?'){
                count = (count == 1 ? arr[i] : (arr[i] * count));
            }
        }
        return count;

    }

}
