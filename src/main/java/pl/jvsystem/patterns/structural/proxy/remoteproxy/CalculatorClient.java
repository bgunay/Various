package pl.jvsystem.patterns.structural.proxy.remoteproxy;

import java.rmi.*;
import java.rmi.registry.*;

public class CalculatorClient
{

	public static void main(String[] args) throws Exception
	{
		// utworzenie managera bezpiecze�stwa
		if (System.getSecurityManager() == null)
		{
			System.setSecurityManager(new RMISecurityManager());
		}

		if (args.length != 3)
		{
			System.out.println("Jako argumenty musisz poda�: ");
			System.out.println("1. Dzia�anie: add, sub, mul, div");
			System.out.println("2. 3. Liczby w postaci 0xVAL, gdzie warto�� oznacza liczb� hex");
			return;
		}

		if (args[0].equals("add") || args[0].equals("sub") || args[0].equals("mul") || args[0].equals("div"))
		{
			CalculatorI calc = (CalculatorI) Naming.lookup("//127.0.0.1:2005/CalculatorServer");
			try
			{
				int result = calc.makeOperation(args[0], args[1], args[2]);
				System.out.println("Otrzymany wynik z serwera: " + Integer.toHexString(result));
			}
			catch (NumberFormatException e)
			{
				System.out.println("Niepoprawne wartosci jako argumenty, hex 0-F");
				return;
			}
		}
		else
		{
			System.out.println("Dost�pne s� 4 dzia�ania: add, sub, mul, div");
			return;
		}

	}
}