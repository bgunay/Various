package com.github.pnowy.various.patterns.structural.proxy.headfirst;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ZdalnyImpl extends UnicastRemoteObject implements Zdalny {
	private static final long serialVersionUID = 1L;

	protected ZdalnyImpl() throws RemoteException {}

	@Override
	public String powiedzHej() throws RemoteException {
		return "serwer mówi hej";
	}
	
	public static void main(String[] args) throws Exception {
		Zdalny usluga = new ZdalnyImpl();
		Naming.rebind("ZdalneHej", usluga);
	}

}
