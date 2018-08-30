package com.hello.world.javacore.mutilThread.fork.example.L4;

/**
 * Created by xing on 2018/8/30.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Synchronized Objects : ");
        Worker worker = new Worker();
        worker.main();
        System.out.println("Synchronized Methods : ");
        WorkerMethodsSynchronized work2 = new WorkerMethodsSynchronized();
        work2.main();
    }
}
