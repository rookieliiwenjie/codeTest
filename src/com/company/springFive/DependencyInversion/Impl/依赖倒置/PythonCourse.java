package com.company.springFive.DependencyInversion.Impl.依赖倒置;

/**
 * Created by lwj32 on 2021/6/29.
 */
public class PythonCourse implements ICourse {
    @Override
    public void study() {
        System.out.println(" Python Course " );
    }
}
