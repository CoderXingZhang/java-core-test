package com.hello.world.javacore.design.pattern.bridge;

/**
 * @author xing
 */
public class Rectangle extends Shape {
    private int x;
    private int y;

    public Rectangle(int x, int y,DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
    }


    @Override
    public void draw() {
        drawAPI.draw(0,x,y);
    }
}
