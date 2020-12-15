package com.company.dem;

import java.net.MalformedURLException;

public class urlDemo {
    public static void main(String[] args) throws MalformedURLException {
        System.out.println(formate("http://gkml.samr.gov.cn/nsjg/ggjgs/201902/t20190220_290934.html"));
        java.net.URL url = new java.net.URL("https://www.xiaohongshu.com/explore");
        String x = url.getProtocol();
        System.out.println(x);
    }

    public static String formate(String urlformte) {
        try {
            java.net.URL url = new java.net.URL(urlformte);
            StringBuilder sb = new StringBuilder();

            return sb.append(url.getProtocol()).append("://").append(url.getHost())
                    .toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "";
    }
}
