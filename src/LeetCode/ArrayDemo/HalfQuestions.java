package LeetCode.ArrayDemo;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/2 12:35 上午
 * @Description:
 * https://leetcode.cn/problems/WqXACV/description/
 * 完成一半题目
 */
public class HalfQuestions {
    public static void main(String[] args) {
        int arr[] = {1000,1000};
        int arr2[]={1,5,1,3,4,5,2,5,3,3,8,6};
        System.out.println("arr = " + halfQuestions(arr));
        System.out.println("arr = " + halfQuestions(arr2));
    }
    public static int halfQuestions(int[] questions) {
        int num = questions.length/2;
        HashMap<Integer,Integer> questionsNum = new HashMap<>();
        for (int i = 0; i < questions.length; i++) {
            questionsNum.put(questions[i],questionsNum.getOrDefault(questions[i],0)+1);
        }

        Integer[] objects = questionsNum.values().stream().toArray(Integer[]::new);
        Arrays.sort(objects);
        int c = 0;
        for (int i = objects.length-1; i >= 0 && num>0; i--) {
            num-=objects[i];
            c++;
            if(num<=0){
                break;
            }
        }
        return c;
    }

    public static int halfQuestions2(int[] questions) {
        int num = questions.length/2;
        int []questionsNum = new int[1001];
        for (int q:questions) {
            questionsNum[q]=questionsNum[q]+1;
        }
        Arrays.sort(questionsNum);
        int c= 0;
        for (int i = questionsNum.length-1; i >= 0 && num>0; i--) {
                num-=questionsNum[i];
                c++;
        }
        return c;
    }



    public int halfQuestionss(int[] questions) {

        int[]count = new int[1001];
        for (int q : questions) {
            count[q]++;
        }
        int n = questions.length;
        int[] map = new int[n + 1];
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                map[count[i]]++;
            }
        }

        int k = n / 2;
        int ret = 0;
        for (int i = n; i >= 1; i--) {

            if (map[i] != 0) {
                int total = map[i] * i;
                if (k > total) {
                    ret += map[i];
                    k -= total;
                } else {

                    ret += k / i;
                    if (k % i != 0)
                        ret++;
                    break;
                }
            }
        }
        return ret;
    }
}
