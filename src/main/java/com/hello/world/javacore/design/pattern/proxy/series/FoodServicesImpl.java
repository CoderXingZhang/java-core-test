package com.hello.world.javacore.design.pattern.proxy.series;

import com.hello.world.javacore.design.pattern.proxy.series.domain.Chicken;
import com.hello.world.javacore.design.pattern.proxy.series.domain.Food;
import com.hello.world.javacore.design.pattern.proxy.series.domain.Noodle;

/**
 * @author xing
 */
public class FoodServicesImpl implements FoodServices {
    @Override
    public Food makeChicken() {
        Food food = new Chicken();

        return food;
    }

    @Override
    public Food makeNodele() {
        Food food = new Noodle();

        return food;
    }
}
