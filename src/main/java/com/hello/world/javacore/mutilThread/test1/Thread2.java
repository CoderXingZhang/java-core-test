package com.hello.world.javacore.mutilThread.test1;

/**
 * @author xing
 */
public class Thread2 implements Runnable {
    private int count = 15;

    @Override
    public void run() {
        //每个线程跑5次--
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "运行 count = " + count--);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread2 my = new Thread2();
        new Thread(my, "B").start();
        new Thread(my, "C").start();
        new Thread(my, "D").start();
//        new Thread(my,"E").start();
//        new Thread(my,"F").start();

    }
}
