package com.company.bug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FullDemo {
    public static void main(String args[]) {
        Student student= new Student();
        ArrayList<Student> sutdents = new ArrayList<>();
        sutdents.add(student);
        student.setAget(11);
        student.setName("name");
        sutdents.sort(Collections.reverseOrder());
        System.out.println(sutdents.get(0).toString());
        
    }

    static class Student {
        String name;
        Integer aget;
        public void setAget(Integer aget) {
            this.aget = aget;
        }
        public Integer getAget() {
            return aget;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        @Override
        public String toString() {
            return ""+this.aget+"name"+this.name;
        }
    }
}
