package com.hello.world.javacore.mutilThread.fork.example.L2;

import java.util.Scanner;

/**
 * Created by xing on 2018/8/30.
 */

/*
* 读取字段将看到最近写入的值
*
* */
class Process extends Thread{
    private volatile boolean running = true;
    @Override
    public void run(){
        while (running){
            System.out.println("running -- ");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void shutdown(){
        running = false;
    }
}
public class VolatileTest {
    public static void main(String[] args) {
        Process pro = new Process();
        pro.start();

        System.out.println("Enter something to stop the thread,\nVolatile variable running will be forced to true :");
        new Scanner(System.in).nextLine();
        pro.shutdown();

    }
}
