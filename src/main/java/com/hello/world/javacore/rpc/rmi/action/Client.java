package com.hello.world.javacore.rpc.rmi.action;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry("127.0.0.1",8088);
            String[] list = registry.list();
            for (String s:list) {
                System.out.println(s);
            }
        }catch (RemoteException e){
            System.out.println(e.getMessage());
        }

        try {
            IService service = (IService) registry.lookup("vince");
            String res = service.queryName("hahaha world");
            System.out.println("result from remote :"  + res);
        }catch (AccessException e){

        }catch (RemoteException e){

        }catch (NotBoundException e){

        }
    }
}
