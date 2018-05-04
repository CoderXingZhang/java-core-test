package com.hello.world.javacore.mutilThread.threadcommunication;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author xing
 */
public class InstanceCallBackDigest implements Runnable{
    private String filename;
    private InstanceCallBackDigestUserInterface callback;

    public InstanceCallBackDigest(String filename, InstanceCallBackDigestUserInterface callback) {
        this.filename = filename;
        this.callback = callback;
    }


    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(filename);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in,sha);
            while (din.read() != -1){};
            din.close();
            byte[] digest = sha.digest();
            System.out.println("计算完毕：通知主线程");
            callback.receiveDigest(digest);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }catch (NoSuchAlgorithmException e){
            System.out.println(e.getMessage());
        }
    }
}
