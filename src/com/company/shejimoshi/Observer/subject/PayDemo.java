package com.company.shejimoshi.Observer.subject;

import com.company.shejimoshi.Observer.observer.AbstractPayAction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/11 11:42 下午
 * @Description:
 */
public class PayDemo {
    private List<AbstractPayAction> actions = new ArrayList<>();

//    public PayDemo() {
//        this.actions = actions;
//    }

    public void registry(AbstractPayAction abstractPayAction) {
        this.actions.add(abstractPayAction);
    }

    public void notifyAllObstract() {
        if (actions != null && actions.size() > 0) {
            actions.forEach(action -> action.payAction(action.name));
        }
    }

    public void pay() {
        System.out.println(" 支付一笔");
        notifyAllObstract();
    }
}
