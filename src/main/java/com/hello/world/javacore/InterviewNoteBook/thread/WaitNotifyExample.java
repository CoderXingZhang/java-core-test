package com.hello.world.javacore.InterviewNoteBook.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitNotifyExample {
    public synchronized void before(){
        System.out.println("before");
        notifyAll();
    }

    public synchronized void after(){
        try {
            wait();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        WaitNotifyExample waitNotifyExample = new WaitNotifyExample();
        executorService.execute(() -> waitNotifyExample.after());
        executorService.execute(()-> waitNotifyExample.before());
    }
}

/**
 *
 * wait() 是 Object 的方法，而 sleep() 是 Thread 的静态方法；
 * wait() 会释放锁，sleep() 不会
 */
