package com.company.javaEigt.JavaEightDemo.chapterOne;

import com.company.javaEigt.JavaEightDemo.domain.Transaction;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/5 12:18 上午
 * @Description:
 */
public class SortDemo {
    public static void main(String[] args) {
        List<Transaction> transactions = Transaction.transactionList();
        System.out.println("transactions = " + transactions);
//       // transactions.sort(Comparator.comparing(Transaction::getPrice));
//        System.out.println("transactions after = " + transactions);
//        /**
//         * 如果想使用Comparrator.reverseOrder()
//         * 对应实体类需要实现implements Comparable<T> 接口 同时实现对应方法compareTo
//         */
//        // transactions.sort(Comparator.reverseOrder());
//        System.out.println("transactions reversedafter = " + transactions);
        transactions.sort(Comparator.comparing(Transaction::getPrice).reversed());
        System.out.println("transactions reversedafter = " + transactions);
    }
}
