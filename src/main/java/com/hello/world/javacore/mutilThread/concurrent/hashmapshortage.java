package com.hello.world.javacore.mutilThread.concurrent;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xing
 */
public class hashmapshortage {
    public static void main(String[] args) throws Exception{
        final HashMap<String,String> map = new HashMap<String, String>(10000);
//        final ConcurrentHashMap<String,String> map = new ConcurrentHashMap<String, String>(10000);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;i++){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(),"");
//                            System.out.println(Thread.currentThread().getName());
                        }
                    },"ftf" + i).start();
                }
            }
        },"ftf");
        t.start();
        t.join();

        System.out.println(map.size());
        System.out.println(map.keySet().size());
        System.out.println(map.values().size());
    }
}
