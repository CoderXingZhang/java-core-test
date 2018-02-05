package com.hello.world.javacore.design.pattern.creater.series.factory;

import com.hello.world.javacore.design.pattern.creater.series.factory.domain.Food;

/**
 * @author xing
 */
public class ChineseFoodFactory implements FooderFactory {
    @Override
    public Food makeFood(String name) {
        if (name.equals("A")){
            return null;
        }else if (name.equals("B")){
            return null;
        }
        return null;
    }
}
