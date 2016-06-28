package com.github.pnowy.various.patterns.structural.proxy.remoteproxy;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

public class CalculatorServer extends UnicastRemoteObject implements CalculatorI
{

	//implementacja interfejsu
	public int makeOperation(String op, String val1, String val2) throws RemoteException
	{
		System.out.println("Serwer przetwarza zadanie");
		System.out.println("OPERATION " + op + " VAL1: " + val1 + " VAL2: " + val2);
		int v1 = 0;
		int v2 = 0;
		try
		{
			v1 = Integer.valueOf(val1, 16);
			v2 = Integer.valueOf(val2, 16);
		}
		catch (NumberFormatException e)
		{
			System.out.println("Zadanie nieprzetworzone - zle argumenty");
			return 0;
		}

		int res = 0;
		if (op.equals("add"))
		{
			res = v1 + v2;
		}
		else if (op.equals("sub"))
		{
			res = v1 - v2;
		}
		else if (op.equals("mul"))
		{
			res = v1 * v2;
		}
		else if (op.equals("div"))
		{
			res = v1 / v2;
		}
		else
		{
			System.out.println("Nieznane dzialanie");
		}
		return res;
	}

	// funkcja raportuj�ca
	private void report()
	{
		System.out.println("Liczba aktywnych watkow: " + Thread.activeCount());
		System.out.println("Nazwa watku: " + Thread.currentThread().getName());
	}

	//konstruktor wyrzucajacy wyjatek
	public CalculatorServer() throws RemoteException
	{
		super(); //wywolywane automatycznie
		report();
	}

	//rejestracja serwisu RMI
	public static void main(String[] args) throws Exception
	{
		// utworzenie managera bezpiecze�stwa
		if (System.getSecurityManager() == null)
		{
			System.setSecurityManager(new RMISecurityManager());
		}

		CalculatorServer calc = new CalculatorServer();
		Naming.bind("//127.0.0.1:2005/CalculatorServer", calc);
		System.out.println("Serwer utworzony");
	}
}