package com.hello.world.javacore.mutilThread.threadcommunication;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author xing
 */
public class MultiThreadMaxFinder {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] data = new int[20000];
        Random random = new Random(9000L);
        for (int i=0;i < 20000;i++){
            data[i] = random.nextInt();
        }
        System.out.println(max(data));
    }

    public static int max(int[] data) throws InterruptedException, ExecutionException {
        if (data.length == 1) {
            return data[0];
        } else if (data.length == 0) {
            throw new IllegalArgumentException();
        }

        FindMaxTask task1 = new FindMaxTask(data, 0, data.length / 2);
        FindMaxTask task2 = new FindMaxTask(data, data.length / 2, data.length);

//        ExecutorService service = Executors.newFixedThreadPool(2);
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService service = new ThreadPoolExecutor(2, 200, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024),
                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());


        Future<Integer> future1 = service.submit(task1);
        Future<Integer> future2 = service.submit(task2);

        System.out.println(future1.get());
        System.out.println(future2.get());

        return Math.max(future1.get(), future2.get());

    }

}
