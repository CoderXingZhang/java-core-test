package com.hello.world.javacore.mutilThread.fork.example.L4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author xing
 */
public class Worker {
    private Random random = new Random();
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();


    public void stageOne (){
        synchronized (lock1){
            try {
                System.out.println(Thread.currentThread().getName()+ "worker stage one --");
                Thread.sleep(10);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            list1.add(random.nextInt(100));
        }
    }

    public void stageTwo(){
        synchronized (lock2){
            try {
                System.out.println(Thread.currentThread().getName()+"worker stage two --");
                Thread.sleep(10);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            list2.add(random.nextInt(100));
        }
    }

    public void process (){
        for (int i = 0; i < 10; i++){
            stageOne();
            stageTwo();
        }
    }

    public void main(){
        System.out.println("starting ..");
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
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        long end = System.currentTimeMillis();
        System.out.println("time taken ： " + (end -start));
        System.out.println("list1 size : " + list1.size() + " list2 size : " +list2.size());

    }


}
