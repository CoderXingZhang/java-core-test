package com.hello.world.javacore.rpc.socket1.provider;

public class BatterCakeServiceImpl implements BatterCakeService {
    @Override
    public String sellBatterCake(String name) {
        return name + " 煎饼，买的特别好！";
    }
}
