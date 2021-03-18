package com.company.DailyCode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @Author rookie.li
 * @create 2021/3/9
 */
public class FunctionUtil {
    private static Map<Integer, Supplier<String>> actionMappings = new HashMap<>(); // 这里泛型 ? 是为方便演示，实际可替换为你需要的类型

    //Map<String, Function<List<Integer>, Integer>> calculateMap = new HashMap<>();
    // 初始化
    static {
        actionMappings.put(1,FunctionUtil::doAction1);
       /* actionMappings.put(2, (someParams) -> {
            doAction2(someParams);
        });
        actionMappings.put(3, (someParams) -> {
            doAction3(someParams);
        });*/

    }


    private static String doAction3() {
        System.out.println("doAction3 someParams = " );
        return "1";
    }

    private static void doAction2(String someParams) {
        System.out.println("doAction2 someParams = " + someParams);
    }

    private static String doAction1() {
        System.out.println("doAction3 someParams = " );
        return "1";
    }
    // 省略多余逻辑语句
    public static void main(String[] args) {
        actionMappings.get(1).get();
    }
}
