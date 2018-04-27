package com.hello.world.javacore.mutilThread.threadcommunication;

/**
 * @author xing
 * 线程里面的任务交替执行，
 *
 * 首先创建一个 A 和 B 共享的对象锁 lock = new Object();
当 A 得到锁后，先打印 1，然后调用 lock.wait() 方法，交出锁的控制权，进入 wait 状态；
对 B 而言，由于 A 最开始得到了锁，导致 B 无法执行；直到 A 调用 lock.wait() 释放控制权后， B 才得到了锁；
B 在得到锁后打印 1， 2， 3；然后调用 lock.notify() 方法，唤醒正在 wait 的 A;
A 被唤醒后，继续打印剩下的 2，3。

 */
public class CrossTheadExample1 {
    public static void main(String[] args) {
        final Object lock = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("INFO :A 等待锁");
                synchronized (lock){
                    System.out.println("INFO : A 得到了锁lock");
                    System.out.println("A 1");
                    try {
                        System.out.println("INFO : A准备进入等待状态，放弃锁lock的控制权");
                        lock.wait();
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }

                    System.out.println("INFO: 有人唤醒了A， A重新获得了锁lock");
                    System.out.println("A 2");
                    System.out.println("A 3");
                }
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("INFO : B 等待锁");
                synchronized (lock){
                    System.out.println("INFO : B 得到了锁lock");
                    System.out.println("B 1");
                    System.out.println("B 2");
                    System.out.println("B 3");
                    System.out.println("INFO : B 打印完毕，调用notify方法");
                    lock.notify();
                }
            }
        });

            A.start();
            B.start();
    }
}
