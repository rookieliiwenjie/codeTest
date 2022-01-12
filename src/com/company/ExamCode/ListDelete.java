package com.company.ExamCode;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

public class ListDelete {
    public static void main(String[] args) {

    }

    public static List<String> deleteSameCode(List<String> examples) {
        List<String> newExample = new ArrayList<>();
        if (examples.isEmpty()) {
            return examples;
        }
        //循环每个string
        return newExample;
    }

    public static class Department {
        private Long id;
        private String name;
        private List<Department> children;
    }

    public static List<Long> findDepartment(Department root, String findName) {
        Queue<Department> departmentQueue = new LinkedList<>();
        departmentQueue.add(root);
        List<Long> findId = new ArrayList<>();
        while (!departmentQueue.isEmpty()) {
            Department poll = departmentQueue.poll();
            if (poll.name.equals(findName)) {
                findId.add(poll.id);
            }
            if (poll.children.isEmpty()) {
                departmentQueue.addAll(poll.children);
            }
        }
        return findId;
    }

    public static List<Long> findTopTen(List<List<Long>> arrs) {
        List<Long> newArr = new ArrayList<>();
        if (arrs.isEmpty()) {
            return newArr;
        }
        arrs.forEach(arr -> {
            Collections.sort(arr);
            Long aLong = arr.get(arr.size() - 1);
            newArr.add(aLong);
        });
        Collections.sort(newArr);
        return newArr.subList(newArr.size() - 11, newArr.size());
    }


}
