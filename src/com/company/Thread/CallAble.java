package com.company.Thread;

import java.util.concurrent.*;

/**
 * @Author: wenjie.li
 * @Date: 2023/5/5 12:11 上午
 * @Description:
 */
public class CallAble implements Callable<Integer> {
    int x = 1;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public Integer call() throws Exception {
//        TimeUnit.SECONDS.sleep(1);
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        return x;
    }

    public static void main(String[] args) {
            ExecutorService service = Executors.newFixedThreadPool(3);
            CallAble callAble = new CallAble();
            callAble.setX(1);
            CallAble callAble2 = new CallAble();
            callAble2.setX(2);
            Future<Integer> submit = service.submit(callAble);
            Future<Integer> submit1 = service.submit(callAble2);
            try {
                submit.get();
                submit1.get();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                service.shutdown();
            }

    }
}
