package com.company.shejimoshi.AbstrabeFactory.newPa;

public class Main {
    public static void main(String[] args) {
        SoftwareAbtrabe softwareAbtrabe= new WindowsFactory();
        ApplicatetionAbs applicatetion = softwareAbtrabe.createApplicatetion();
        applicatetion.open();
        softwareAbtrabe.create();
    }
}
