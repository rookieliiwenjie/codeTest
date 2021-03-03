package com.company.并发编程.day15_2021_03_02;

import com.sun.tools.javac.util.StringUtils;
import com.sun.xml.internal.bind.v2.runtime.output.Encoded;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @Author rookie.li
 * @create 2021/3/2
 */
public class EncodeDemo {
    public static void main(String[] args) {
        String liwenjie = encode("奋斗");
        String pwd = "AMP001" + "00000000" + "123456" + System.currentTimeMillis();
        System.out.println("pwd = " + pwd);
        String j10003000000001111110803192020 = getMD5Str(pwd);
        System.out.println("liwenjie = " + liwenjie);
        System.out.println("liwenjie = " + j10003000000001111110803192020);
    }

    public static String encode(String str) {
        if (str != null && str.length() > 0) {
            try {
                String encodeStr = URLEncoder.encode(str, "UTF-8");
                return encodeStr;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String getMD5Str(String str) {
        if (str != null && str.length() > 0) {
            byte[] digest = null;
            try {
                MessageDigest md5 = MessageDigest.getInstance("md5");
                digest = md5.digest(str.getBytes("utf-8"));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //16是表示转换为16进制数
            String md5Str = new BigInteger(1, digest).toString(16);
            return md5Str;
        }
        return null;
    }

}
