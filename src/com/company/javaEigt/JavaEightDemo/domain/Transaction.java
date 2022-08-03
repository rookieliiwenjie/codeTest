package com.company.javaEigt.JavaEightDemo.domain;

import lombok.Data;
import lombok.ToString;

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
}
