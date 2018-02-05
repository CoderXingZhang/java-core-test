package com.hello.world.javacore.design.pattern.creater.series.factory;

import com.hello.world.javacore.design.pattern.creater.series.factory.domain.Food;

/**
 * @author xing
 */
public interface FooderFactory {
    Food makeFood(String name);
}
