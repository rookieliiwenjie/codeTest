package com.company.ExamDemo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 输入两个字符串S，T，将S进行N次变换得到与T相同的字符串，求N的最小次数
 *
 *
 *
 * 约束
 *
 *  输入源字符串S，目标字符串T ，输入的字符必须是小写字母，范围在a~e之间 ，允许重复;
 *
 *  字符串长度 L 满足 1 <= L <=5， S和T长度相等, 一次只能交换单个任意字符，
 *
 * 不符合的输入，输出”输入不合法“，不可转换成目标字符串的，输出9999
 *
 *
 *
 * 输入描述
 *
 * public int calculateStep(String source, String target)
 * 参数说明：source，输入的源字符串，target，要转换的目标字符串
 *输入：abcde,edabc
 *
 * 输出： 3
 */
public class StringSwapDemo {
    public static void main(String args[]){
        int i = calculateStep("abcde", "edabc");
        System.out.println(i);
    }
    public static int  calculateStep(String source,String target){
        int sum = 0;
        String s = "";
        List<Integer> indexList = new ArrayList<Integer>();
        for(int i = 0;i<source.length();i++){
            char c = source.charAt(i);
            for(int j = i;j<target.length();j++){
                if(i!=j && c==target.charAt(j) && !indexList.contains(j)){
                    sum++;
                }
                s=s+c;
                indexList.add(j);
            }
        }
        return sum == 0?9999:sum;

    }
    //originalList : 源集合
    // pageSize : 单页数量
    // pageNumber : 指定的页数
    public List getSubList(List originalList, int pageSize, int pageNumber){
        if(originalList == null || originalList.isEmpty()){
            return null;
        }
        //设置总页数
        int len = originalList.size();
        int start = (pageNumber - 1) * pageSize;
        //对list进行截取
        return originalList.subList(start,len-start>pageNumber?start+pageSize:len);
    }

}
