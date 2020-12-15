package com.company.CASDemo;

/**
 * Created by lwj32 on 2020/5/14.
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS
 * compareAndSwap 比较并交换 是一个并发原语
 * 功能：他的功能就是判断内存中 某一个位置的值是否为预期值，如果是则修改，整个过程是原子的
 * 体现：主要体现在调用java rt.jar下的unsafe类，这个类下面很多都是native方法，所以底层操作时面向地址值的，
 * 当我们调用Unsafe类的时候，JVM会为我们实现CAS汇编的语言，这个本身依赖于硬件，通过这个可以完成原子性操作，
 * 因为CAS是一系列的系统原语，而原语的执行必须是连续的，所以整个过程是不
 * 可以被打断，也就是说CAS是一条Cpu的原子指令，因此不会出现数据不一致的问题
 * 缺点：循环时间长开销大,
 */
public class CasDemo {
    public static void main(String args[]) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2020) + "\t" + atomicInteger.get());
        /**源码解析
         * 1. public final int getAndIncrement() {
         *
         *         return unsafe.getAndAddInt(this（这个对象）, valueOffset(地址值 内存偏移量), 1);
         *     }
         * 2.   private static final Unsafe unsafe = Unsafe.getUnsafe();
         *     private static final long valueOffset;
         *
         *     static {
         *         try {
         *             valueOffset = unsafe.objectFieldOffset
         *                 (AtomicInteger.class.getDeclaredField("value"));
         *         } catch (Exception ex) { throw new Error(ex); }
         *     }
         *
         *     private volatile int value;
         *     3.底层实现
         *      public final int getAndAddInt(Object var1, long var2, int var4) {
         *         int var5;
         *         do {
         *             var5 = this.getIntVolatile(var1, var2);//获取当前值
         *         } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4)
         *         //CAS比较如果为true跳出循环var5+var4执行加操作反之亦然);
         *
         *         return var5;
         *     }
         */
        atomicInteger.getAndIncrement();

    }
}
