package com.github.pnowy.various.ocjp.chapter2;

public class TestConstructors
{

    public static void main(String[] args)
    {
	new Y("aaa");
    }

}

abstract class X
{
    X(String a)
    {
	System.out.println("To jest konstruktor A");
    }
}

class Y extends X
{
    
    Y()
    {
	super("");
    }
    
    Y(String b)
    {
	super(b);
	System.out.println("To jest konstruktor B");
    }
}