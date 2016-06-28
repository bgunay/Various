package com.github.pnowy.various.ocjp.chapter8;

public class MetodInnerClass
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
	abstract class A
	{
	    public abstract int go();
	    public final void go2()
	    {
		System.out.println("final");
	    }
	}
	
	A a = new A()
	{
	    
	    @Override
	    public int go()
	    {
		return 0;
	    }
	};
	a.go2();
    }

}
