package com.hello.world.javacore.design.pattern;

import com.hello.world.javacore.design.pattern.creater.series.bulider.mode1.User;

/**
 * @author xing
 */
public class dpTest {
    public static void main(String[] args) {
        User u = User.builder().name("zx").password("1223").nickName("san").bulid();

    }
}
