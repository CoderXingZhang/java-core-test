package com.hello.world.javacore.mutilThread.threadcommunication;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xing
 */
public class SendMessageToMainThread1 {
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Task starts ");
                Thread.sleep(1000);
                int result = 0;
                for (int i= 0;i<=100;i++){
                    result += i;
                }
                System.out.println("task finished and return result");
                return result;
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        new Thread(futureTask).start();

        try {
            System.out.println("Before futureTask.get()");
            System.out.println("Result: " + futureTask.get());
            System.out.println("After future Task get()");
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }catch (ExecutionException e){
            System.out.println(e.getMessage());
        }
    }
}
