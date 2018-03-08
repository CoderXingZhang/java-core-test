package com.hello.world.javacore.mutilThread.test1;

/**
 * @author xing
 */
public class Thread1 extends Thread{
    private int count =5;
    private String name;

    public Thread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i =0;i<5;i++){
            System.out.println(name + "运行 count = " + count--);
            try{
                Thread.sleep((int)Math.random() * 10);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread1 mth1 = new Thread1("A");
        Thread1 mth2 = new Thread1("B");
        mth1.start();
        mth2.start();

    }
}
