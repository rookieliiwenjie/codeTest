package com.company.BlockingQueueDemo;

import javax.management.relation.RoleList;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by lwj32 on 2020/5/26.
 * 1.当队列为空时向队列获取值时阻塞
 * 2.当队列为满时向队列添加值时阻塞
 * ArrayBlockingQueue有数组结构组成的有界阻塞队列
 * LinkedBlockingQueue由链表组成的有界阻塞队列（但大小是Integer.MAX）
 * SynchronousQueue不存储元素的阻塞列表，也即为单元素队列
 * LinkedBlockingDeque:由链表组成的双向阻塞队列
 * DelayQueue使用 优先级队列实现的延迟无边界
 * PriorityBlockingQueue 支持优先级的无边界阻塞列表
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("A");
        blockingQueue.put("B");
        blockingQueue.put("C");
        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + blockingQueue.take());
        }
      /*  System.out.println("blockingQueue.add(\"1\") = " + blockingQueue.add("1"));
        System.out.println("blockingQueue.add(\"2\") = " + blockingQueue.add("2"));
        System.out.println(blockingQueue.add("3"));
        System.out.println(blockingQueue.element());
        blockingQueue.remove();
        blockingQueue.remove();
        System.out.println("blockingQueue.element() = " + blockingQueue.element());
        for (Iterator<String> it = blockingQueue.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println("s = " + s);


        }*/
     /* blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        System.out.println("blockingQueue.take() = " + blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println("blockingQueue.take() = " + blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println("blockingQueue.take() = " + blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println("blockingQueue.take() = " + blockingQueue.poll(2,TimeUnit.SECONDS));*/
        /*SynchronousQueue<String > synchronousQueue = new SynchronousQueue<>();

        new Thread(()->{
            try {
                synchronousQueue.put("A");
                synchronousQueue.take();
                synchronousQueue.put("A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()->{
            try {
                System.out.println(synchronousQueue.take()+"\n");
                synchronousQueue.put("B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(()->{
            try {
                System.out.println(synchronousQueue.take()+"/n");
                synchronousQueue.put("C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
*/

      /*  for(int i=0;i<blockingQueue.size();i++){
            System.out.println("blockingQueue.take() = " + blockingQueue.take());

        }*/


    }
}
