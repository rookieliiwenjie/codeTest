package com.company.springFive.DependencyInversion.Impl.依赖倒置;

import com.company.springFive.DependencyInversion.Impl.依赖倒置.ICourse;

/**
 * Created by lwj32 on 2021/6/29.
 */
public class Tom {
    public void study(ICourse course){
        course.study();
    }
}
