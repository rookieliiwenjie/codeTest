package com.company.LeetCode;

import com.sun.tools.corba.se.idl.StringGen;

import java.util.Arrays;

/**
 * @Author: wenjie.li
 * @Date: 2023/4/25 11:13 下午
 * @Description:
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 *
 *
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */
public class StrToInt {
    public static void main(String[] args) {
       String s = "6\n" +
               "7\n" +
               "8\n" +
               "9\n" +
               "10\n" +
               "47\n" +
               "13\n" +
               "14\n" +
               "15\n" +
               "16\n" +
               "18\n" +
               "24\n" +
               "20\n" +
               "21\n" +
               "22\n" +
               "23\n" +
               "19\n" +
               "25\n" +
               "26\n" +
               "27\n" +
               "28\n" +
               "12\n" +
               "30\n" +
               "32\n" +
               "33\n" +
               "34\n" +
               "35\n" +
               "36\n" +
               "37\n" +
               "38\n" +
               "82\n" +
               "40\n" +
               "41\n" +
               "42\n" +
               "43\n" +
               "44\n" +
               "45\n" +
               "46\n" +
               "29\n" +
               "48\n" +
               "49\n" +
               "50\n" +
               "51\n" +
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
               "62\n" +
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
               "79\n" +
               "80\n" +
               "81\n" +
               "39\n" +
               "83\n" +
               "84\n" +
               "85\n" +
               "86\n" +
               "87\n" +
               "88\n" +
               "89\n" +
               "90\n" +
               "91\n" +
               "92\n" +
               "93\n" +
               "94\n" +
               "95\n" +
               "96\n" +
               "97\n" +
               "98\n" +
               "99\n" +
               "100\n" +
               "101\n" +
               "102\n" +
               "103\n" +
               "104\n" +
               "105\n" +
               "106\n" +
               "107\n" +
               "108\n" +
               "109\n" +
               "110\n" +
               "111\n" +
               "112\n" +
               "113\n" +
               "114\n" +
               "115\n" +
               "116\n" +
               "117\n" +
               "118\n" +
               "119\n" +
               "120\n" +
               "121\n" +
               "122\n" +
               "123\n" +
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
               "134\n" +
               "135\n" +
               "136\n" +
               "137\n" +
               "138\n" +
               "139\n" +
               "140\n" +
               "141\n" +
               "142\n" +
               "143\n" +
               "144\n" +
               "145\n" +
               "146\n" +
               "147\n" +
               "148\n" +
               "149\n" +
               "150\n" +
               "151\n" +
               "152\n" +
               "153\n" +
               "154\n" +
               "155\n" +
               "156\n" +
               "157\n" +
               "158\n" +
               "159\n" +
               "160\n" +
               "161\n" +
               "162\n" +
               "163\n" +
               "164\n" +
               "165\n" +
               "166\n" +
               "167\n" +
               "168\n" +
               "169\n" +
               "170\n" +
               "171\n" +
               "172\n" +
               "173\n" +
               "174\n" +
               "175\n" +
               "176\n" +
               "177\n" +
               "178\n" +
               "179\n" +
               "180\n" +
               "181\n" +
               "182\n" +
               "183\n" +
               "184\n" +
               "185\n" +
               "186\n" +
               "187\n" +
               "188\n" +
               "189\n" +
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
               "221\n" +
               "222\n" +
               "223\n" +
               "224\n" +
               "225\n" +
               "226\n" +
               "227\n" +
               "228\n" +
               "229\n" +
               "230\n" +
               "231\n" +
               "232\n" +
               "233\n" +
               "234\n" +
               "235\n" +
               "236\n" +
               "237\n" +
               "238\n" +
               "239\n" +
               "240\n" +
               "241\n" +
               "242\n" +
               "243\n" +
               "244\n" +
               "245\n" +
               "246\n" +
               "247\n" +
               "248\n" +
               "249\n" +
               "250\n" +
               "251\n" +
               "252\n" +
               "253\n" +
               "254\n" +
               "255\n" +
               "256\n" +
               "257\n" +
               "258\n" +
               "259\n" +
               "260\n" +
               "261\n" +
               "262\n" +
               "263\n" +
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
               "279\n" +
               "280\n" +
               "281\n" +
               "282\n" +
               "283\n" +
               "284\n" +
               "285\n" +
               "286\n" +
               "287\n" +
               "288\n" +
               "289\n" +
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
               "304\n" +
               "305\n" +
               "306\n" +
               "307\n" +
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
               "319\n" +
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
      s = s.replaceAll("\n",",");
        System.out.println("s = " + s);
        System.out.println("sl = " + s.split(",").length );

    }
    public static int strToInt(String str) {
        boolean falg = false;
        int flag =1;
        boolean falgfu = false;
        long x = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if(falg){
                    break;
                }
            } else if (Character.isDigit(str.charAt(i)) ) {
                falg= true;
                x = x * 10 + (str.charAt(i) - '0') * flag;
                if (flag == -1 && x < Integer.MIN_VALUE) {
                    return  Integer.MIN_VALUE;
                } else if (flag == 1 &&  x > Integer.MAX_VALUE) {
                    return  Integer.MAX_VALUE;
                }
            } else if (Character.isDigit(str.charAt(i)) && falgfu) {
                x = 0;
                break;
            }else if( str.charAt(i) == '-'){
                if(falgfu){
                    break;
                }
                falgfu= true;
                falg = true;
                flag = -1;
            }else if(str.charAt(i) == '+'){
                if(falgfu){
                    break;
                }
                falgfu= true;
                falg = true;
            }  else {
                break;
            }
        }

        return (int)x;

    }

}
