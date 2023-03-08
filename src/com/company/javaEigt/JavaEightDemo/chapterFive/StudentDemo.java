package com.company.javaEigt.JavaEightDemo.chapterFive;

import com.company.javaEigt.JavaEightDemo.domain.StudentNew;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: wenjie.li
 * @Date: 2023/2/3 1:22 下午
 * @Description: map与flatMap的区别
 */
public class StudentDemo {
    public static void main(String[] args) {
        //年级
        List<Map<String, List<StudentNew>>> gradeManageList = new ArrayList<>();
        //班级：每个年级有两个班级
        Map<String, List<StudentNew>> classManageMap1 = new HashMap<>();
        Map<String, List<StudentNew>> classManageMap2 = new HashMap<>();
        //学生:每个班级里面有两个List<StudentNew>，分别代表男生和女生
        List<StudentNew> boyStudentList1 = new ArrayList<>();
        List<StudentNew> grilStudentList1 = new ArrayList<>();

        boyStudentList1.add(new StudentNew("小牛", 1, "男"));
        boyStudentList1.add(new StudentNew("小刺猬", 3, "男"));

        grilStudentList1.add(new StudentNew("小花", 4, "女"));
        grilStudentList1.add(new StudentNew("小草", 5, "女"));
        grilStudentList1.add(new StudentNew("小蜻蜓", 7, "女"));

        //一班
        classManageMap1.put("男生", boyStudentList1);
        classManageMap1.put("女生", grilStudentList1);

//        //学生集合List<StudentNew>
//        List<StudentNew> boyStudentList2 = new ArrayList<>();
//        List<StudentNew> grilStudentList2 = new ArrayList<>();
//
//        boyStudentList2.add(new StudentNew("2-1", "男", "小羊"));
//        boyStudentList2.add(new StudentNew("2-2", "男", "小牛"));
//        boyStudentList2.add(new StudentNew("2-3", "男", "小刺猬"));
//
//        grilStudentList2.add(new StudentNew("2-4", "女", "小花"));
//        grilStudentList2.add(new StudentNew("2-5", "女", "小草"));
//        grilStudentList2.add(new StudentNew("2-6", "女", "小蜻蜓"));
//
//        //二班
//        classManageMap2.put("男生", boyStudentList2);
//        classManageMap2.put("女生", grilStudentList2);

        //放进年级列表
        gradeManageList.add(classManageMap1);
        gradeManageList.add(classManageMap2);

        //parseTest(gradeManageList);
        parseTest2(gradeManageList);

    }

    public static void parseTest(List<Map<String, List<StudentNew>>> gradeManageList) {

        // .map与.flatMap的区别

        //.map获取两个班级所有的男生的集合
        List<List<StudentNew>> boyLists = gradeManageList.stream()
                .map(classManageMap -> classManageMap.get("男生"))
                .collect(Collectors.toList());
        System.out.println("gradeManageList.toString() = " + gradeManageList);
        List<List<StudentNew>> boyListss = gradeManageList.stream().filter(gra -> !gra.isEmpty()).map(gra -> gra.get("男生")).collect(Collectors.toList());
        System.out.println("boyListss.toString() = " + boyListss.toString());

        //.flatMap获取两个班级所有男生的集合，返回一个List<Student>
        List<StudentNew> boyList = gradeManageList.stream()
                .filter(gre -> !gre.isEmpty())
                .flatMap(classManageMap -> classManageMap.get("男").stream())
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());


        System.out.println("boyList.toString() = " + boyList.toString());


    }


    public static void parseTest2(List<Map<String, List<StudentNew>>> gradeManageList) {
        System.out.println("gradeManageList.toString() = " + gradeManageList);
        //.flatMap获取两个班级所有男生的集合，返回一个List<Student>
        Optional<StudentNew> ageSum = gradeManageList.stream()
                .filter(gre -> (gre != null && gre.size() > 0))
                .flatMap(classManageMap -> {
                    if(!classManageMap.get("男").isEmpty() && classManageMap.get("男").size()>0){
                        return classManageMap.get("男").stream();
                    }
                    return null;
                }).filter(Objects::nonNull)
                .filter(studentNew -> (studentNew != null && studentNew.getAge() != null))
                .reduce((v1, v2) -> v1.getAge() > v2.getAge() ? v1 : v2);
        System.out.println("ageSum.get() = " + ageSum.get());
        System.out.println("boyList.toString() = " + ageSum);
    }

}

