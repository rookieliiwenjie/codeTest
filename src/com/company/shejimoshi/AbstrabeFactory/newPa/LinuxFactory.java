package com.company.shejimoshi.AbstrabeFactory.newPa;

public class LinuxFactory implements SoftwareAbtrabe{
    @Override
    public SystemAbstrable create() {
        System.out.println("linux");
        return new LinuxSystem();
    }

    @Override
    public ApplicatetionAbs createApplicatetion() {
        return new WordApplicatetionAbs();
    }
}
