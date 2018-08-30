package com.hello.world.javacore.mutilThread.fork.example.L4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author xing
 */
public class WorkerMethodsSynchronized {
    private Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public synchronized void stageOne(){
        try {
            System.out.println(Thread.currentThread().getName()+"method syn stage 1..");
            Thread.sleep(10);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        list1.add(random.nextInt(100));
    }

    public synchronized void stageTwo(){
        try {
            System.out.println(Thread.currentThread().getName()+"method syn stage 2 ..");
            Thread.sleep(10);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        list2.add(random.nextInt(100));
    }

    public void process(){
        for (int i = 0; i< 10;i++){
            stageOne();
            stageTwo();
        }
    }

    public void main() {
        System.out.println("start ing ..");
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        t1.start();t2.start();
        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){

        }

        long end = System.currentTimeMillis();

        System.out.println("time taken: " + (end - start));
        System.out.println("list1 size : " + list1.size() + "; list2 size : " + list2.size());
    }

}
