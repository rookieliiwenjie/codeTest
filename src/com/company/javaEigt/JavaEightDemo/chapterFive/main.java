package com.company.javaEigt.JavaEightDemo.chapterFive;

/**
 * @Author: wenjie.li
 * @Date: 2022/11/24 5:18 下午
 * @Description:
 */
public class main {
    public static void main(String[] args) {
        String s = "13243\n" +
                "11313\n" +
                "12290\n" +
                "15127\n" +
                "17184\n" +
                "19317\n" +
                "18825\n" +
                "19193\n" +
                "19400\n" +
                "19595\n" +
                "19880\n" +
                "20258\n" +
                "18445\n" +
                "17749\n" +
                "18329\n" +
                "16558\n" +
                "16974\n" +
                "16983\n" +
                "16009\n" +
                "15361\n" +
                "18144\n" +
                "18304\n" +
                "16291\n" +
                "17182\n" +
                "3790\n" +
                "20815\n";

        String[] split = s.split("\n");
        System.out.println(split.length);
        int sum  = 0;
        for (String x :
                split) {
            sum+= Integer.valueOf(x);
//            System.out.print(x + ",");
        }
        System.out.println(sum);
//        92,214,230,322,336,12962,14522,15762,21721,39761,41201,49361,49401,49441,49481,50401,50641,53001,57241,57481,57801,58521,58641,64122,64162,64202,64562,64642,64682,64722,64922,65042,65082,6700,67242,67322,67722,67762,67802,67842,67882,67922,67962,68002,68042,68082,68162,68242,68322,68482,68562,68762,68882,68962,69042,69122,69282,69362,65202,

    }
}
