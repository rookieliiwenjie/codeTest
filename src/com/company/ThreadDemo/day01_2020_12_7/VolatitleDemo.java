package com.company.ThreadDemo.day01_2020_12_7;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData {
     int number = 0;
    AtomicInteger atomicInteger = new AtomicInteger(1);
    //添加synchronized实现原子性
    public  synchronized void addNumber() {
        this.number = 60;
    }
    public  void  addNumberPul(){
        number++;
    }
    public void  myAtomicAdd(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1.1未加volatile时可见性没有实现，无法跳出循环
 * {
 * AAA  come in
 * * AAA    update number value is60
 * }
 * 1.2添加volatile时可见性实现，跳出循环
 * 打印结果{
 * AAA  come in
 * AAA  update number value is60
 * update number is ok60
 * }
 * 2.1volatitle 不保证原子性，不可分割完整性，
 * 也就是某个线程在处理问题时其他无法加塞和被分割，也就是要保证完整性和也就是成功或者失败
 如何解决:
 使用juc下的AtomicInteger
 */
public class VolatitleDemo {

    public static void main(String args[]) {
        seeOkByVolatitle();
        //demo();


    }

    private static void demo() {
        MyData myData = new MyData();
        for(int i = 0;i<20;i++){
            new Thread(()->{
                for(int j = 0;j<1000;j++){
                    myData.addNumberPul();
                    myData.myAtomicAdd();
                }
            },String.valueOf(i)).start();


        }
        //等待20个线程执行完毕，再通过main线程取得最终的结果值
        while (Thread.activeCount()>2){
            Thread.yield();

        }
        System.out.println(Thread.currentThread().getName()+"\t fianl number is"+myData.number);
        System.out.println(Thread.currentThread().getName()+"atomic  number is ok" + myData.atomicInteger);
    }

    //volatitle保证原子性，及时通知主内存的值发生了改变
    public static void seeOkByVolatitle() {
        MyData myData = new MyData();
      //  Thread thread = new Thread();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addNumber();

            System.out.println(Thread.currentThread().getName() + "\t update number value is" + myData.number);
        }, "AAA").start();

        while (myData.number == 0) {
            //测试是否成功修改了值如果没有则一直在循环
        }
        System.out.println("int number is ok" + myData.number);
    }
}
