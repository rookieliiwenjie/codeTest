package com.company.MyLockRecefreLock;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by lwj32 on 2020/6/27.
 */
public class Demo {
    private MyLock myLock = new MyLock();

    public void a() {
        myLock.lock();
        System.out.println(" a");
        b();
        myLock.unlock();
    }

    public void b() {
        myLock.lock();
        System.out.println(" b() ");
        c();
        myLock.unlock();

    }

    public void c() {
        myLock.lock();
        System.out.println(" c() ");
        myLock.unlock();

    }

    public static void main(String[] args) {
//        Demo demo = new Demo();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                demo.a();
//            }
//        }).start();
//        int key = 1;
//        switch (key) {
//            case 1:
//            case 2:
//                System.out.println("key = " + key);
//                return;
//            case 3:
//                System.out.println("3 = ");
//                return;
//            default:
//                System.out.println("default = ");
//                return;
//        }

        String s = "1\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "47\n" +
                "13\n" +
                "14\n" +
                "15\n" +
                "16\n" +
                "20\n" +
                "21\n" +
                "22\n" +
                "23\n" +
                "25\n" +
                "26\n" +
                "28\n" +
                "30\n" +
                "32\n" +
                "33\n" +
                "34\n" +
                "35\n" +
                "36\n" +
                "38\n" +
                "82\n" +
                "40\n" +
                "42\n" +
                "43\n" +
                "44\n" +
                "45\n" +
                "46\n" +
                "49\n" +
                "52\n" +
                "53\n" +
                "54\n" +
                "55\n" +
                "56\n" +
                "57\n" +
                "58\n" +
                "59\n" +
                "60\n" +
                "61\n" +
                "63\n" +
                "64\n" +
                "65\n" +
                "66\n" +
                "67\n" +
                "68\n" +
                "69\n" +
                "70\n" +
                "71\n" +
                "72\n" +
                "73\n" +
                "74\n" +
                "75\n" +
                "76\n" +
                "77\n" +
                "78\n" +
                "39\n" +
                "85\n" +
                "86\n" +
                "88\n" +
                "89\n" +
                "91\n" +
                "96\n" +
                "98\n" +
                "99\n" +
                "102\n" +
                "103\n" +
                "104\n" +
                "105\n" +
                "107\n" +
                "109\n" +
                "116\n" +
                "117\n" +
                "118\n" +
                "119\n" +
                "120\n" +
                "122\n" +
                "124\n" +
                "125\n" +
                "126\n" +
                "127\n" +
                "128\n" +
                "129\n" +
                "130\n" +
                "131\n" +
                "132\n" +
                "133\n" +
                "135\n" +
                "137\n" +
                "138\n" +
                "140\n" +
                "141\n" +
                "144\n" +
                "145\n" +
                "146\n" +
                "148\n" +
                "149\n" +
                "150\n" +
                "153\n" +
                "154\n" +
                "156\n" +
                "157\n" +
                "158\n" +
                "160\n" +
                "162\n" +
                "163\n" +
                "164\n" +
                "166\n" +
                "168\n" +
                "169\n" +
                "171\n" +
                "174\n" +
                "175\n" +
                "177\n" +
                "178\n" +
                "179\n" +
                "180\n" +
                "181\n" +
                "183\n" +
                "184\n" +
                "185\n" +
                "187\n" +
                "190\n" +
                "191\n" +
                "192\n" +
                "193\n" +
                "194\n" +
                "195\n" +
                "196\n" +
                "197\n" +
                "198\n" +
                "199\n" +
                "200\n" +
                "201\n" +
                "202\n" +
                "203\n" +
                "205\n" +
                "206\n" +
                "207\n" +
                "208\n" +
                "209\n" +
                "210\n" +
                "211\n" +
                "212\n" +
                "213\n" +
                "214\n" +
                "215\n" +
                "216\n" +
                "217\n" +
                "218\n" +
                "219\n" +
                "220\n" +
                "222\n" +
                "224\n" +
                "225\n" +
                "226\n" +
                "228\n" +
                "229\n" +
                "230\n" +
                "231\n" +
                "232\n" +
                "234\n" +
                "236\n" +
                "237\n" +
                "238\n" +
                "239\n" +
                "242\n" +
                "243\n" +
                "246\n" +
                "247\n" +
                "248\n" +
                "249\n" +
                "251\n" +
                "252\n" +
                "253\n" +
                "254\n" +
                "255\n" +
                "256\n" +
                "258\n" +
                "259\n" +
                "260\n" +
                "261\n" +
                "262\n" +
                "264\n" +
                "265\n" +
                "266\n" +
                "267\n" +
                "268\n" +
                "269\n" +
                "270\n" +
                "271\n" +
                "272\n" +
                "273\n" +
                "274\n" +
                "275\n" +
                "276\n" +
                "277\n" +
                "278\n" +
                "280\n" +
                "281\n" +
                "282\n" +
                "283\n" +
                "284\n" +
                "286\n" +
                "287\n" +
                "288\n" +
                "290\n" +
                "291\n" +
                "292\n" +
                "293\n" +
                "294\n" +
                "295\n" +
                "296\n" +
                "297\n" +
                "298\n" +
                "299\n" +
                "300\n" +
                "301\n" +
                "302\n" +
                "303\n" +
                "305\n" +
                "306\n" +
                "308\n" +
                "309\n" +
                "310\n" +
                "311\n" +
                "312\n" +
                "313\n" +
                "314\n" +
                "315\n" +
                "316\n" +
                "317\n" +
                "318\n" +
                "320\n" +
                "321\n" +
                "322\n" +
                "323\n" +
                "324\n" +
                "325\n" +
                "326\n" +
                "327\n" +
                "328\n" +
                "329\n" +
                "330\n" +
                "331\n" +
                "332\n" +
                "333\n" +
                "334\n" +
                "335\n" +
                "336\n" +
                "337\n" +
                "338\n" +
                "339\n" +
                "340\n" +
                "341\n" +
                "342\n" +
                "343\n" +
                "344\n" +
                "345\n" +
                "346\n" +
                "347\n" +
                "348\n" +
                "349\n" +
                "350\n" +
                "351\n" +
                "352\n" +
                "353\n" +
                "354\n" +
                "355\n" +
                "356\n" +
                "359\n" +
                "360\n" +
                "361\n" +
                "362\n" +
                "363\n" +
                "364\n" +
                "365\n" +
                "366\n" +
                "367\n" +
                "368\n" +
                "369\n" +
                "370\n" +
                "371\n" +
                "372";
        String collect = Arrays.stream(s.split("\n")).map(str -> str.replaceAll(" ", "").replaceAll("\n","")).collect(Collectors.joining(","));
        System.out.println( collect);
        System.out.println("collect = " + collect.split(",").length);;

    }
}
