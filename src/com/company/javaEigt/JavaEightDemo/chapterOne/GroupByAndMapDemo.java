package com.company.javaEigt.JavaEightDemo.chapterOne;

import com.company.javaEigt.JavaEightDemo.domain.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/4 12:38 上午
 * @Description:
 */
public class GroupByAndMapDemo {
    public static void main(String[] args) {
//        Transaction transaction = new Transaction("RMB", 1000L);
//        Transaction transaction2 = new Transaction("RMB", 2000L);
//        Transaction transaction3 = new Transaction("RMB", 5000L);
//
//
//        Transaction transactionUs = new Transaction("US", 1000L);
//        Transaction transactionUs2 = new Transaction("US", 2000L);
//        Transaction transactionUs3 = new Transaction("US", 5000L);
//
//        List<Transaction> transactions = new ArrayList<>();
//        transactions.add(transaction);
//        transactions.add(transaction2);
//        transactions.add(transaction3);
//        transactions.add(transactionUs);
//        transactions.add(transactionUs2);
//        transactions.add(transactionUs3);
//        Map<String, List<Transaction>> tradeTypeMap = transactions.stream()
//                .filter(transaction1 -> transaction1.getPrice() > 1000L)
//                .collect(groupingBy(Transaction::getTradeType));
//        tradeTypeMap.keySet().forEach(key -> {
//            System.out.println("key = " + key);
//            System.out.println("key = " + tradeTypeMap.get(key));
//        });
//        List<Integer> s = new ArrayList<>();
//        s.add(1);
//        s.add(2);
//        s.add(5);
//        int sum = 0;
//        for (Integer k: s) {
//            if(sum >= s.size()-1){
//                System.out.println("sum = " + k);
//            }
//            sum++;
//        }
//        System.out.println("sumbefoe = " + sum);
        if (true) {
            System.out.println("if = " );
        } else if (true) {
            System.out.println("else if = " );
        } else {
            System.out.println("else" );
        }

    }

}
