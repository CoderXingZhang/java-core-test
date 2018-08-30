package com.hello.world.javacore.mutilThread.fork.example.L5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author xing
 */
public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0;i< 3; i++){
            executorService.submit(new Processor(i));
        }
        //不再接受新的线程了
        executorService.shutdown();

        System.out.println("all tasks submited");
        try{
            executorService.awaitTermination(1, TimeUnit.DAYS);
        }catch (Exception e){
        }
        System.out.println("all tasks completed ");

    }
}
class Processor implements Runnable {

    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting : "+ id);
        try {
            Thread.sleep(2000);
        }catch (Exception e){
        }

        System.out.println("completed : " + id);

    }


}
