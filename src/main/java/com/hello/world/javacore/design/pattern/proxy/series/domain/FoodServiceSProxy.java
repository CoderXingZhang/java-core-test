package com.hello.world.javacore.design.pattern.proxy.series.domain;

import com.hello.world.javacore.design.pattern.proxy.series.FoodServices;
import com.hello.world.javacore.design.pattern.proxy.series.FoodServicesImpl;

/**
 * @author xing
 */
public class FoodServiceSProxy implements FoodServices {
    private FoodServices foodServices = new FoodServicesImpl();

    @Override
    public Food makeChicken() {

        return foodServices.makeChicken();
    }

    @Override
    public Food makeNodele() {
        return foodServices.makeNodele();
    }
}
