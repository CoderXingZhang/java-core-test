package com.hello.world.javacore.mutilThread.threadcommunication;

import javax.xml.bind.DatatypeConverter;

/**
 * @author xing
 */
public class InstanceCallBackDigestUserInterface {
    private String filename;
    private byte[] digest;


    public InstanceCallBackDigestUserInterface(String filename) {
        this.filename = filename;
    }

    public void calculateDigest(){
        InstanceCallBackDigest cb = new InstanceCallBackDigest(filename,this);
        System.out.println(filename +" : 开始计算");
        Thread t = new Thread(cb);
        t.start();
    }

    void receiveDigest(byte[] digest){
        this.digest = digest;
        System.out.println(this);
    }

    @Override
    public String toString() {
        String result = filename + " : ";
        if (digest != null){
            result += DatatypeConverter.printHexBinary(digest);
        }else {
            result +="digest not available ";
        }
        return result;
    }

    public static void main(String[] args) {
        for (String filename : args){
            InstanceCallBackDigestUserInterface d = new InstanceCallBackDigestUserInterface(filename);
            d.calculateDigest();
        }
    }
}
