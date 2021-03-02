package com.company.并发编程.day15_2021_03_02;

import com.sun.xml.internal.bind.v2.runtime.output.Encoded;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author rookie.li
 * @create 2021/3/2
 */
public class EncodeDemo {
    public static void main(String[] args) {
        try {
            String liwenjie = URLEncoder.encode("奋斗", "UTF-8");
            getMD5Str("12345");
            System.out.println("liwenjie = " + liwenjie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

        public static String getMD5Str(String str) {
            byte[] digest = null;
            try {
                MessageDigest md5 = MessageDigest.getInstance("md5");
                digest  = md5.digest(str.getBytes("utf-8"));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //16是表示转换为16进制数
            String md5Str = new BigInteger(1, digest).toString(16);
            return md5Str;
        }

}
