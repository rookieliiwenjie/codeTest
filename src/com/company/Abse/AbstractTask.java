package com.company.Abse;

public abstract class AbstractTask implements ITask {
    @Override
    public void excute() {
        run();

    }

    public void run() {
        selectTask();
        System.out.println(" AbstractTask + run");
    }

    public abstract void selectTask();

}