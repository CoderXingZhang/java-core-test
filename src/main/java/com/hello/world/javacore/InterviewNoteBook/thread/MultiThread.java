package com.hello.world.javacore.InterviewNoteBook.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MultiThread {
    public static void main(String[] args) throws Exception{
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread mythred = new Thread(futureTask);

        mythred.start();
        System.out.println(futureTask.get());
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(10000);
        return 111+ 222;
    }
}