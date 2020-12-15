package com.company.ThreadDemo.day03_2020_12_10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author rookie.li
 * @create 2020/12/10
 */
public class ThreadLocalOomDemo {

    private static final int THREAD_LOOP_SIZE = 500;
    private static final int MOCK_DIB_DATA_LOOP_SIZE = 10000;
    static ThreadLocal<List<User>> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        /*ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), new ThreadPoolExecutor.AbortPolicy());*/
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_LOOP_SIZE);
        for (int i = 0; i < THREAD_LOOP_SIZE; i++) {
            executorService.execute(() -> {
                threadLocal.set(new ThreadLocalOomDemo().addBigList());
                System.out.println(Thread.currentThread().getName());
                //threadLocal.remove(); //不取消注释的话就可能出现OOM
            });
            /*try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }


    }

    private List<User> addBigList() {
        List<User> params = new ArrayList<>(MOCK_DIB_DATA_LOOP_SIZE);
        for (int i = 0; i < MOCK_DIB_DATA_LOOP_SIZE; i++) {
           // System.out.println("i = " + Thread.currentThread().getName() +"==="+ i);
            params.add(new User(Thread.currentThread().getName(), "password" + i, "男", i));
        }
        return params;
    }
}
