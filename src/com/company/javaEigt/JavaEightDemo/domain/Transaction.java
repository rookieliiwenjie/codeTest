package com.company.javaEigt.JavaEightDemo.domain;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/4 12:38 上午
 * @Description:
 */
@Data
@ToString
public class Transaction {
    private String tradeType;
    private Long price;

    public Transaction(String tradeType, Long price) {
        this.tradeType = tradeType;
        this.price = price;
    }

    public static List<Transaction> transactionList(){
        Transaction transaction = new Transaction("RMB", 1000L);
        Transaction transaction2 = new Transaction("RMB", 2000L);
        Transaction transaction3 = new Transaction("RMB", 5000L);
        Transaction transactionUs = new Transaction("US", 1000L);
        Transaction transactionUs2 = new Transaction("US", 2000L);
        Transaction transactionUs3 = new Transaction("US", 5000L);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transactionUs);
        transactions.add(transactionUs2);
        transactions.add(transactionUs3);
        return transactions;
    }
}
