package com.hello.world.javacore.mutilThread.threadcommunication;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author xing
 */
public class ReadyForOthersThread1 {
    public static void main(String[] args) {
        int runner = 3;
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);
        final Random random = new Random();
        for (char runerName = 'A';runerName <= 'C';runerName++){
            final String rN = String.valueOf(runerName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long prepareTime = random.nextInt(10000) + 100;
                    System.out.println(rN + " is preparing for time : "+ prepareTime);
                    try {
                        Thread.sleep(prepareTime);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    try {
                        System.out.println(rN + " is prepared ; waiting for others");
                        cyclicBarrier.await();
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }catch (BrokenBarrierException e){
                        System.out.println(e.getMessage());
                    }

                    System.out.println(rN + " starts running ! ");
                }
            }).start();
        }
    }
}
