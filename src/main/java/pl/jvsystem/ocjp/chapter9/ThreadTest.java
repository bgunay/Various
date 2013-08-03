package pl.jvsystem.ocjp.chapter9;


public class ThreadTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
	int i = 10;
	while (i++ <= 10) // sprawdzenie jest wykonywane kolejny raz !!!
	{
	    System.out.println(i);
	    i++;
	}
	
	System.out.print(i);
	
	Roman r = Roman.X;
	switch (r)
	{
	    case Y:
	    default:	
	}
	
    }

    public static void printB(String str)
    {
	System.out.print(Boolean.valueOf(str) ? "true" : "false");
    }

}

enum Roman { X, Y, Z}

class Alpha
{
    int go() throws InterruptedException
    {
	return 0;
    }
}

class Beta extends Alpha
{
    
}