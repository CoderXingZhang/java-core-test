package com.hello.world.javacore.mutilThread.fork.example.L1;

/**
 * Created by xing on 2018/8/30.
 */
class RunnerRunnable implements Runnable{

    @Override
    public void run() {
        for (int i= 0 ;i < 5 ;i++){
            System.out.println("hello :" +i +" thread : " + Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}

public class ApplicationRunnable {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnerRunnable(),"one");
        Thread thread2 = new Thread(new RunnerRunnable(),"two");
        thread1.start();
        thread2.start();
    }
}
