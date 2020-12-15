package com.company.SingleonDemo;

import java.util.HashMap;

/**
 * Created by lwj32 on 2020/6/19.
 */
public class TinyURLUtil {
    static  final String tin_url = "http://tinyrul.com/";
    HashMap<String,String> hashMap = new HashMap();
    public String encodeUrl(String url){
        StringBuffer shortUrl = new StringBuffer(tin_url);
        String randNum = String.valueOf(((Math.random()*9+1)*100000));
        shortUrl.append(randNum);
        if(hashMap.containsKey(shortUrl)){
            hashMap.put(shortUrl.toString(),url);
        }
        return shortUrl.toString();
    }
    public String  decodeUrl(String url){
        return hashMap.get(url);
    }
}
