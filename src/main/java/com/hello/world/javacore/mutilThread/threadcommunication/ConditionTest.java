package com.hello.world.javacore.mutilThread.threadcommunication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xing
 */
public class ConditionTest {
    public static void main(String[] args) throws InterruptedException{
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(myService);
        b.setName("B");
        b.start();

        Thread.sleep(3000);
        myService.signalAll_A();
    }
}

class ThreadA extends Thread{
    private MyService myService;
    public ThreadA(MyService myService){
        super();
        this.myService = myService;
    }
    @Override
    public void run(){
        myService.awaitA();
    }
}

class ThreadB extends Thread{
    private MyService myService;
    public ThreadB(MyService myService){
        super();
        this.myService = myService;
    }
    @Override
    public void run(){
        myService.awaitB();
    }
}

class MyService{
    private Lock lock = new ReentrantLock();
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();

    public void awaitA(){
        lock.lock();
        try {
            System.out.println("begin awaitA时间为 : " + System.currentTimeMillis()
            + "ThreadName = " + Thread.currentThread().getName());
            conditionA.await();
            System.out.println(" end awaitA时间为 : "  + System.currentTimeMillis()
            + "ThreadName = " + Thread.currentThread().getName());
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }finally {
            lock.unlock();
        }
    }

    public void awaitB(){
        lock.lock();
        try {
            System.out.println("Begin awaitB 时间为 ： " + System.currentTimeMillis()
            + " ThreadName = " + Thread.currentThread().getName());
            conditionB.await();
            System.out.println(" end awaitB时间为 ： "+ System.currentTimeMillis()
            + " ThreadName = " + Thread.currentThread().getName());
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }finally {
            lock.unlock();
        }
    }

    public void signalAll_A(){
        try {
            lock.lock();
            System.out.println(" signalAll_A时间为 ： "+ System.currentTimeMillis()
            + "ThreadName = " + Thread.currentThread().getName());
            conditionA.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void signalAll_B(){
        try {
            lock.lock();
            System.out.println(" signalAll_B时间为 ： "+ System.currentTimeMillis()
            + " ThreadName = " + Thread.currentThread().getName());
            conditionB.signalAll();
        }finally {
            lock.unlock();
        }
    }
}