package com.hello.world.javacore.mutilThread.threadcommunication;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xing
 */

class ValueObject{
    public static List<String> list = new ArrayList<String>();
}

public class LockTest1 {
    public static void main(String[] args) throws InterruptedException{
        String lock = new String("");
        ThreadSubStract subStract1 = new ThreadSubStract("subreact1Thread",lock);
        subStract1.start();

        ThreadSubStract subStract2 = new ThreadSubStract("subreact2Thread",lock);
        subStract2.start();

        Thread.sleep(1000);

        ThreadAdd threadAdd = new ThreadAdd("addThread",lock);
        threadAdd.start();
    }
}



class ThreadAdd extends Thread{
    private String lock;


    public ThreadAdd(String name, String lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            ValueObject.list.add("anyString");
            lock.notifyAll();
        }
    }
}

class ThreadSubStract extends Thread{
    private String lock;

    public ThreadSubStract(String name, String lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (ValueObject.list.size() == 0) {
                    System.out.println("wait begin ThreadName = " + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("wait end ThreadName = " + Thread.currentThread().getName());

                }
                ValueObject.list.remove(0);
                System.out.println("list size = " + ValueObject.list.size());
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

