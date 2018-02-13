package com.hello.world.javacore.design.pattern.adapter;

/**
 * @author xing
 */
public class WildCock implements Cock {
    @Override
    public void gobble() {
        System.out.println("咕咕叫");
    }

    @Override
    public void fly() {
        System.out.println("鸡也会飞啊");
    }
}
