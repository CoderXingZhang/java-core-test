package com.hello.world.javacore.mutilThread.fork.example.L3;

/**
 * Created by xing on 2018/8/30.
 */
public class Worker {
    private int count = 0;

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.doWork();
    }

    public  void increment(String threadName) throws InterruptedException{
        count++;
        System.out.println("Thread in process : " + threadName + " and count is " + count);
    }

    public void doWork(){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0; i< 10 ; i++){
                    try {
                        increment(Thread.currentThread().getName());
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        },"one");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0 ; i<10 ;i ++){
                    try {
                        increment(Thread.currentThread().getName());
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        },"two");
        thread2.start();

//        try {
//            thread1.join();
//            thread2.join();
//        }catch (InterruptedException e ){
//            System.out.println(e.getMessage());
//        }
        System.out.println("Count is : " + count);
    }


}

