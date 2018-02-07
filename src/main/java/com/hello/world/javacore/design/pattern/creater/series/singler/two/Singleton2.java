package com.hello.world.javacore.design.pattern.creater.series.singler.two;

/**
 * @author xing
 */

/**
 * 饱汉模式
 */
public class Singleton2 {
    //首先也是将new Singleton2()堵死
    private Singleton2(){}
    //和饿汉模式相比，这里不需要在这实例化出来，
    private static volatile Singleton2 instance = null;
    public static Singleton2 getInstance(){
        if (instance == null){
            //加锁
            synchronized (Singleton2.class){
                //这次判断也需要，不然会有并发问题
                if (instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
