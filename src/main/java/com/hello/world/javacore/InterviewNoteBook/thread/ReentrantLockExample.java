package com.hello.world.javacore.InterviewNoteBook.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private Lock lock = new ReentrantLock();
    public void fun1(){
        lock.lock();
        try {
            for (int i =0 ;i< 10;i++){
                System.out.println("int i " + i);
            }

        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> example.fun1());
        executorService.execute(() -> example.fun1());
    }
}
