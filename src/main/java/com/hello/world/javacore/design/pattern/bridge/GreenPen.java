package com.hello.world.javacore.design.pattern.bridge;

/**
 * @author xing
 */
public class GreenPen implements DrawAPI {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("用绿色笔画图， radius : " + radius + ",x : " + x + ", y : " + y);
    }
}
