package com.company.MyLockRecefreLock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

        String s =
                "81\n" +
                "92\n" +
                "29\n" +
                "62\n" +
                "143\n" +
                "244\n" +
                "95\n" +
                "147\n" +
                "101\n" +
                "223\n" +
                "114\n" +
                "186\n" +
                "84\n" +
                "93\n" +
                "152\n" +
                "50\n" +
                "182\n" +
                "134\n" +
                "113\n" +
                "257\n" +
                "139\n" +
                "263\n" +
                "289\n" +
                "27\n" +
                "112\n" +
                "115\n" +
                "279\n" +
                "176\n" +
                "188\n" +
                "151\n" +
                "100\n" +
                "51\n" +
                "233\n" +
                "94\n" +
                "250\n" +
                "240\n" +
                "90\n" +
                "142\n" +
                "159\n" +
                "307\n" +
                "83\n" +
                "80\n" +
                "241\n" +
                "172\n" +
                "189\n" +
                "136\n" +
                "173\n" +
                "12\n" +
                "97\n" +
                "108\n" +
                "87\n" +
                "235\n" +
                "37\n" +
                "285\n" +
                "48\n" +
                "167\n" +
                "170\n" +
                "79\n" +
                "106\n" +
                "111\n" +
                "319\n" +
                "245\n" +
                "221\n" +
                "165\n" +
                "304\n" +
                "41\n" +
                "121\n" +
                "19\n" +
                "161\n" +
                "155\n" +
                "227\n" +
                "110";
        String collect = Arrays.stream(s.split("\n")).map(str -> str.replaceAll(" ", "").replaceAll("\n","")).collect(Collectors.joining(","));
        //String collect = Arrays.stream(s.split("\n")).map(str -> str.replaceAll(" ", "").replaceAll("\n","")).collect(Collectors.joining(""));
        System.out.println( collect);
        System.out.println("数量 = " + collect.split(",").length);;

//        String s2= "1,7,8,9,47,13,14,15,16,20,21,22,23,25,26,28,30,32,33,34,35,36,38,82,40,42,43,44,45,46,49," +
//                "52,53,54,55,56,57,58,59,60,61,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78," +
//                "39,85,86,88,89,91,96,98,99,102,103,104,105,107,109,116,117,118,119,120,122," +
//                "124,125,126,127,128,129,130,131,132,133,135,137,138,140,141,144,145,146,148,149,150,153," +
//                "154,156,157,158,160,162,163,164,166,168,169,171,174,175,177,178,179,180,181,183,184,185,187" +
//                ",190,191,192,193,194,195,196,197,198,199,200,201,202,203,205,206,207,208,209,210,211,212,213," +
//                "214,215,216,217,218,219,220,222,224,225,226,228,229,230,231,232,234,236,237,238,239,242,243,246," +
//                "247,248,249,251,252,253,254,255,256,258,259,260,261,262,264,265,266,267,268,269,270,271,272,273,274," +
//                "275,276,277,278,280,281,282,283,284,286,287,288,290,291,292,293,294,295,296,297,298,299,300,301,302," +
//                "303,305,306,308,309,310,311,312,313,314,315,316,317,318,320,321,322,323,324,325,326,327,328,329,330," +
//                "331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355," +
//                "356,359,360,361,362,363,364,365,366,367,368,369,370,371,372";
//        Set<String> set = new HashSet<>();
//        for (String s1 : s.split("\n")) {
//            set.add(s1);
//        }
//        System.out.println("set.size() = " + set.size());
    }
}
