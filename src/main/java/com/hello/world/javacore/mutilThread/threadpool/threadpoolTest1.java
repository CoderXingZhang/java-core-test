package com.hello.world.javacore.mutilThread.threadpool;

import java.util.concurrent.*;

/**
 * @author xing
 */
public class threadpoolTest1 {
    public static void main(String[] args) {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,200,1L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(1024),);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }

        System.out.println("=====end");
    }
}
