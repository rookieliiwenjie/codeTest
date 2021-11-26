package com.company.ExamCode;

import java.io.*;
import java.util.*;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-10-15 15:48
 * 1.请实现一个程序，该程序可以读取文本文件，并对文本中重复出现的字符进行统计（文本为英文文章），
 * 输出按照倒序排序（可以指定记入统计的阈值）
 */
public class AliExamFileDemo {
    static HashMap<String, Long> fileRead = new HashMap<>();

    public static void main(String[] args) {
        readFile("/Users/wenjieli/demo.txt", 20);
    }
    /**
     * @param path 文件路径
     * @param nums 阈值
     */
    public static void readFile(String path, Integer nums) {
        try {
            readFileStream(path, nums);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ListIterator<Map.Entry<String, Long>> readfile = new ArrayList<>(fileRead.entrySet()).listIterator(fileRead.size());
        while (readfile.hasPrevious()) {
            Map.Entry<String, Long> entry = readfile.previous();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static void readFileStream(String path, Integer nums) throws IOException {
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(path));
            String s = null;
            while ((s = bf.readLine()) != null) {
                if (fileRead.containsKey(s)) {
                    Long aLong = fileRead.get(s);
                    //控制阀值
                    if (aLong < nums) {
                        fileRead.put(s, aLong + 1);
                    }
                } else {
                    fileRead.put(s, 1L);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            //打印日志业务代码中
            System.out.println("e = " + e);
        } finally {
            bf.close();
        }
    }

}
