package com.company.MyLockRecefreLock;

/**
 * Created by lwj32 on 2020/6/27.
 */
public class Demo {
    private MyLock myLock = new MyLock();
    public void a(){
        myLock.lock();
        System.out.println(" a" );
        b();
        myLock.unlock();
    }
    public void b(){
        myLock.lock();
        System.out.println(" b() ");
        c();
        myLock.unlock();

    }
    public void c(){
        myLock.lock();
        System.out.println(" c() ");
        myLock.unlock();

    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.a();
            }
        }).start();
    }
}
