package com.company.LaoHan;

import java.util.Queue;
import java.util.Scanner;

public class DequeFontDemo {
    public static void main(String args[]) {
        ArrarQueue arrarQueue = new ArrarQueue(3);//数据最多是maxsize-1因为有一个作为约定
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("a(add)：添加数据");
            System.out.println("e(exit)：退出程序");
            System.out.println("g(get)：出队列");
            System.out.println("h(head)：显示队首数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    arrarQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入要添加的数");
                    int value = scanner.nextInt();
                    arrarQueue.addData(value);
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'g':
                    try {
                        int res = arrarQueue.get();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = arrarQueue.headQueue();
                        System.out.printf("队首数据为%d\n", head);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("请输入正确的符号");
                    break;
            }

        }
        System.out.printf("程序退出");
    }

    static class ArrarQueue {
        private int maxSize;//数组的最大长度
        private int front;//队首
        private int rear;//队尾
        private int[] arrayQuser;//数组
        public ArrarQueue(int arraySize) {
            maxSize = arraySize;
            front = 0;//对头指向
            rear = 0;
            arrayQuser = new int[maxSize];

        }

        //判断队列是否满了
        public boolean isFull() {
            return (rear+1)%maxSize==front;
        }

        //判断队列是否为空
        public boolean isEmpty() {
            return rear == front;
        }

        //出队列操作
        public int get() throws Exception {
            //判断队列是否为空
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            int num =  arrayQuser[front];
            front=(front +1)%maxSize;
            return num;

        }

        //添加数据到队列
        public void addData(int num) {
            if (!isFull()) {
                arrayQuser[rear] = num;
                rear = (rear+1)%maxSize;
            } else {
                System.err.println("对不起队列已满");
            }

        }
        //显示队列所有数据
        public void showQueue() {
        /*  for(int i = front;)*/
        }

        //显示队列头数据
        public int headQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，没有数据");
            }
            return arrayQuser[front];

        }
    }

}
