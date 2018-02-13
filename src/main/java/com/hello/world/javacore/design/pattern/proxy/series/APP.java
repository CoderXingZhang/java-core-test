package com.hello.world.javacore.design.pattern.proxy.series;

import com.hello.world.javacore.design.pattern.proxy.series.domain.FoodServiceSProxy;

/**
 * @author xing
 */
public class APP {
    public static void main(String[] args) {
        FoodServices foodServices = new FoodServiceSProxy();
        foodServices.makeChicken();
    }
}

/**
 * 代理模式 就是方法包装 方法增强
 *
 *
 */
