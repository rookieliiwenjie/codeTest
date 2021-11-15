package com.company.shejimoshi.StategyPattern;

/**
 * 在此填写类的用途、注意事项等
 *
 * @author rookie.li
 * @date 2021-11-10 16:00
 */
public class Centext {
    private Rule rule;

    public Centext(Rule rule) {
        this.rule = rule;
    }

    public String execRule() {
        return rule.rule();
    }
}
