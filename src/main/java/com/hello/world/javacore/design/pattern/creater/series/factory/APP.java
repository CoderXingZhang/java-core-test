package com.hello.world.javacore.design.pattern.creater.series.factory;

import com.hello.world.javacore.design.pattern.creater.series.factory.domain.Food;

/**
 * @author xing
 */
public class APP {
    public static void main(String[] args) {
        FooderFactory factory = new ChineseFoodFactory();
        Food food = factory.makeFood("A");

    }
}
