package com.hello.world.javacore.design.pattern.bridge;

/**
 * @author xing
 */
public class APP {
    public static void main(String[] args) {
        Shape greenCircle = new Circle(10,new GreenPen());
        Shape redRectangle = new Rectangle(4,8,new RedPen());

        greenCircle.draw();
        redRectangle.draw();
    }
}
