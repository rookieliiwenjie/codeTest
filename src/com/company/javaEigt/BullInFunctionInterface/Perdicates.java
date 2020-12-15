package com.company.javaEigt.BullInFunctionInterface;

import java.util.Objects;

/**
 * @Author rookie.li
 * @create 2020/12/8
 */
@FunctionalInterface
public interface Perdicates<T> {

    boolean test(T t);
    default Perdicates<T> and(Perdicates<? super T> perdicates) {
        Objects.requireNonNull(perdicates);
        String app = "";

        return (t) -> test(t) && perdicates.test(t);
    }

}
