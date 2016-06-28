package com.github.pnowy.various.patterns.structural.proxy.headfirst;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Zdalny extends Remote {
	public String powiedzHej() throws RemoteException;
}
