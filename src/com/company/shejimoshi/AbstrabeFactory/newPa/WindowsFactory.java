package com.company.shejimoshi.AbstrabeFactory.newPa;

public class WindowsFactory implements SoftwareAbtrabe{

    @Override
    public SystemAbstrable create() {
        System.out.println("windows");
        return new WindowSystem();
    }

    @Override
    public ApplicatetionAbs createApplicatetion() {
        return new ExcelApplicatetionAbs();
    }
}
