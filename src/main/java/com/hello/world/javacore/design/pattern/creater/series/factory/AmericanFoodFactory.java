package com.hello.world.javacore.design.pattern.creater.series.factory;

import com.hello.world.javacore.design.pattern.creater.series.factory.domain.*;

/**
 * @author xing
 */
public class AmericanFoodFactory implements FooderFactory {
    @Override
    public Food makeFood(String name) {
        if (name.equals("A")){
            return new AmericanFoodA();
        }else if (name.equals("B")){
            return new AmericanFoodB();
        }else {
            return null;
        }
    }
}
