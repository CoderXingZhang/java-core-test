package com.hello.world.javacore.design.pattern.creater.series.factory;

import com.hello.world.javacore.design.pattern.creater.series.factory.domain.ChineseFoodA;
import com.hello.world.javacore.design.pattern.creater.series.factory.domain.ChineseFoodB;
import com.hello.world.javacore.design.pattern.creater.series.factory.domain.Food;

/**
 * @author xing
 */
public class ChineseFoodFactory implements FooderFactory {
    @Override
    public Food makeFood(String name) {
        if (name.equals("A")){
            return new ChineseFoodA();
        }else if (name.equals("B")){
            return new ChineseFoodB();
        }
        return null;
    }
}
