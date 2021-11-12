package com.company.springFive.DependencyInversion.Impl.LawOfDameterLod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwj32 on 2021/7/2.
 */
public class TeamLeader {
    public void getCourseNum(){
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        System.out.println("courseList.size() = " + courseList.size());
    }
}
