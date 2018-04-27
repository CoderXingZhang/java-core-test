package com.hello.world.javacore.mutilThread.threadcommunication;

import java.util.concurrent.CountDownLatch;

/**
 *  @author zhangxing
 *  四个线程 A B C D，其中 D 要等到 A B C 全执行完毕后才执行，而且 A B C 是同步运行的
 *
 */
public class WaitOtherThread {
    public static void main(String[] args) {
        int worker = 3;
        final CountDownLatch countDownLatch = new CountDownLatch(worker);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D is waiting for other three threads");
                try{
                    countDownLatch.await();
                    System.out.println("All down ,D start working");
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        }).start();

        for (char threadName = 'A';threadName <= 'C';threadName++){
            final String tN = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(tN + " is working ");
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println(tN + " finished ");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }
}
