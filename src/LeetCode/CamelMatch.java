package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/4/14 1:42 下午
 * @Description:
 */
public class CamelMatch {

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> camelMatch = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            String pa = queries[i];
            int k = 0;
            boolean flag  = true;
            for (int j = 0; j < pa.length(); j++) {
                if (k < pattern.length() && pa.charAt(j) == pattern.charAt(k)) {
                    k++;
                } else if (Character.isUpperCase(pa.charAt(j))) {
                    flag = false;
                    break;
                }
            }
            if (k != pattern.length()) {
                flag = false;
            }
            camelMatch.add(flag);
        }
        return camelMatch;
    }
}
