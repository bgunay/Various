package com.github.pnowy.various.patterns.structural.proxy.remoteproxy;

import java.rmi.*;

public interface CalculatorI extends Remote
{
	int makeOperation(String operation, String val1, String val2) throws RemoteException;
}