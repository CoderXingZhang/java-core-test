package com.hello.world.javacore.design.pattern.creater.series.singler.one;

import java.util.Date;

/**
 * @author xing
 */

/**
 * 饿汉模式
 */
public class Singleton {

    private String name;
    //首先将new Singleton()堵死
    private Singleton(String name) {
        this.name = name;
    }
    //创建私有静态实例，意味着第一次使用这个类的时候就会创建
    private static Singleton singleton = new Singleton("JDBCConnection");

    public static Singleton getSingleton(){
        return singleton;
    }

    public static Date getDate(String mode) {
        return new Date();
    }

}
