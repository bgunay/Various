package com.github.pnowy.various.ocjp.chapter4;

public class Test extends Thread
{

    static String sName = "good";

    public static void main(String argv[])
    {
	System.out.println(Thread.currentThread().getName());
	Test t = new Test();
	t.nameTest(sName);
	System.out.println(sName);

    }

    public void nameTest(String sName)
    {
	sName = sName + " idea ";
	start();
    }

    public void run()
    {

	for (int i = 0; i < 4; i++)
	{
	    sName = sName + " " + i;
	    System.out.println("wowołuje");
	}
	System.out.println(Thread.currentThread().getName());
    }

}
