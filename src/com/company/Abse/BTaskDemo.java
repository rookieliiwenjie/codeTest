package com.company.Abse;

public class BTaskDemo extends AbstractTask {

    @Override
    public void selectTask() {
        System.out.println("BTaskDemo +selectTask");
    }
    public static void main(String[] args) {
        BTaskDemo bTaskDemo = new BTaskDemo();
        bTaskDemo.excute();
    }

}