package com.hello.world.javacore.mutilThread.threadcommunication;

/**
 * @author xing
 * 让两个线程依次执行
 * 线程A执行完成之后再执行线程B
 */
public class ThreadExample1 {

    public static void main(String[] args) {
        final Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B 开始等待 A");
                try{
                    A.join();
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
                printNumber("B");
            }
        });
        A.start();
        B.start();
    }

    public static void printNumber(String threadName){
        int i = 0;
        while (i++ < 3){
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            System.out.println(threadName + " print : " + i);
        }
    }
}
