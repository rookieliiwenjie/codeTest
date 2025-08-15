package com.company.shejimoshi.ProxyDemo.newProxy;

import java.util.Arrays;

public class ProxyImge implements Image {
    private PcImage pcImage;
    private String fileName;
    private MobileImage mobileImage;

    public ProxyImge(String fileName) {
        if (fileName.equals("PC")) {
            pcImage = new PcImage();
        } else if (fileName.equals("MOBILE")) {
            mobileImage = new MobileImage();
        }
        this.fileName = fileName;
    }


    @Override
    public void look() {
        if (fileName.equals("PC")) {
            pcImage.look();
        } else if (fileName.equals("MOBILE")) {
            mobileImage.look();
        }
    }

    public static void main(String[] args) {
        String s = "100321402\n" +
                "100321403\n" +
                "221785721\n" +
                "100140923\n" +
                "172128961\n" +
                "100140924\n" +
                "100321404\n" +
                "127710682\n" +
                "100321405\n" +
                "192072761\n" +
                "165622801\n" +
                "194392281\n" +
                "101301894\n" +
                "202039961\n" +
                "110165062\n" +
                "110165512\n" +
                "112086582\n" +
                "189907081\n" +
                "100962269\n" +
                "110169162\n" +
                "172127641\n" +
                "165622721\n" +
                "100146151\n" +
                "110165232\n" +
                "110165552\n" +
                "100120850\n" +
                "100143071\n" +
                "127706842\n" +
                "100343115\n" +
                "100499852\n" +
                "172101361\n" +
                "220567761\n" +
                "100499848\n" +
                "112025112\n" +
                "127706962\n" +
                "110175782\n" +
                "100321410\n" +
                "100321411\n" +
                "272652921\n" +
                "100095437\n" +
                "172197241";
        String[] split = s.split("\n");
        String s2 = "";
        for (String s1 : s.split("\n")) {

            s2+=s1 + ",";
//            if (i % 50 == 0) {
//                System.out.println();
//            }
        }
        System.out.println(s2);
    }
}
