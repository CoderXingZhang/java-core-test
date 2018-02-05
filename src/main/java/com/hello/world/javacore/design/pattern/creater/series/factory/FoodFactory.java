package com.hello.world.javacore.design.pattern.creater.series.factory;

import com.hello.world.javacore.design.pattern.creater.series.factory.domain.Food;
import com.hello.world.javacore.design.pattern.creater.series.factory.domain.HuangMenChicken;
import com.hello.world.javacore.design.pattern.creater.series.factory.domain.LanZhouNoodle;

/**
 * @author xing
 */
public class FoodFactory {
    public static Food makeFood(String name) {
        if (name.equals("noddle")){
            Food noddle = new LanZhouNoodle();
            noddle.addSpicy("more");
            return noddle;
        }else if (name.equals("chicken")){
            Food chicken = new HuangMenChicken();
            chicken.addCondiment("potato");
            return chicken;
        }else {
            return null;
        }
    }
}
