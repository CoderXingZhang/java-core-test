package com.hello.world.javacore.mutilThread.fork.example.L1;

/**
 * Created by xing on 2018/8/30.
 */
public class ApplicationExtends {
    public static void main(String[] args) {
        Runner runner1 = new Runner();
        runner1.start();
        Runner runner2 = new Runner();
        runner2.start();
    }
}

class Runner extends Thread{

    @Override
    public void run() {
        for (int i= 0 ;i < 5 ;i++){
            System.out.println("hello" + i+ " thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}