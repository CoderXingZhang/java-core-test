package com.hello.world.javacore.mutilThread.fork.example.L5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by xing on 2018/8/30.
 */
public class WorkerThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        System.out.println("Starting ...");
        long start = System.currentTimeMillis();
        Worker worker = new Worker();
        for (int i = 0; i < 2 ; i++){
            service.submit(worker);
        }
        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.DAYS);
        }catch (Exception e){
        }
        long end = System.currentTimeMillis();
        System.out.println("time taken : " + (end -start));
        System.out.println("List1 size : " + worker.list1.size() + "; List2 size : " + worker.list2.size());
    }
}

class Worker implements Runnable{
    private Random random = new Random();
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public List<Integer> list1 = new ArrayList<>();
    public List<Integer> list2 = new ArrayList<>();

    @Override
    public void run() {
        process();
    }
    public void process(){
        for (int i =0; i < 1000 ;i++){
            stageone();
            stagetwo();
        }
    }

    public void stageone(){
        synchronized (lock1){
            try{
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            list1.add(random.nextInt(100));
        }
    }

    public void stagetwo(){
        synchronized (lock2){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            list2.add(random.nextInt(100));
        }
    }
}