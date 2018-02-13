package com.hello.world.javacore.design.pattern.adapter;

/**
 * @author xing
 */
public class APP {
    public static void main(String[] args) {

        Cock wildCock = new WildCock();

        Duck duck = new CockAdapter(wildCock);
    }
}
