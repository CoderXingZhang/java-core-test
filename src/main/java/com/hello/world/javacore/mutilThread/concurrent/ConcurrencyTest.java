package com.hello.world.javacore.mutilThread.concurrent;

/**
 * @author xing
 */
public class ConcurrencyTest {
    public static final long count = 10000L;

    public static void main(String[] args) throws InterruptedException{
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i< count ;i++){
                    a += 5;
                }
            }
        });
        thread.start();
        int b =0 ;
        for (long i = 0;i< count ;i++){
            b--;
        }
        long time ;



    }
    private static void serial() throws InterruptedException{

    }

}
