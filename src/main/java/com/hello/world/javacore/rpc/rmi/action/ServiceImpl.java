package com.hello.world.javacore.rpc.rmi.action;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceImpl extends UnicastRemoteObject implements IService {

    private static final long serialVersionUID = 423565263263657L;

    protected ServiceImpl() throws RemoteException{
        super();
    }

    @Override
    public String queryName(String no) throws RemoteException {
        System.out.println("hello " + no);
        return String.valueOf(System.currentTimeMillis() + "hello");
    }
}
