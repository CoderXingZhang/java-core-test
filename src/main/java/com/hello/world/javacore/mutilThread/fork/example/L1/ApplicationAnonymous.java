package com.hello.world.javacore.mutilThread.fork.example.L1;

/**
 * Created by xing on 2018/8/30.
 */
public class ApplicationAnonymous {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0 ;i < 5 ; i++){
                    System.out.println("hello " + i + "threads : " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        },"test");


        thread.start();
    }
}
