package com.hello.world.javacore.rpc.rmi.action;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry(8088);
        }catch (RemoteException e){
            System.out.println(e.getMessage());
        }

        try {
            ServiceImpl server = new ServiceImpl();
            registry.rebind("vince",server);
            System.out.println("bind server");

        }catch (RemoteException e){
            System.out.println(e.getMessage());
        }
    }
}
