package com.company.shejimoshi.FlyweightDemo.TreeDemo;

import java.util.HashMap;

public class TreeFactory {
   static HashMap<String, Tree> treeTypeHashMap = new HashMap<>();

    public static Tree getTreeType(String name, String color, String type) {
        Tree tree = treeTypeHashMap.get(name);
        if (tree == null) {
            tree = new Tree(type, color, name);
        }
        return tree;
    }
}
