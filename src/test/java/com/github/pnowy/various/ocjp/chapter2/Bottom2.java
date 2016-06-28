package com.github.pnowy.various.ocjp.chapter2;

class Top
{
    public Top() {}
    
    public Top(String s)
    {
	System.out.println("B");
    }
}

public class Bottom2 extends Top
{

    public static void main(String[] args)
    {

    }
    
    public Bottom2(String s)
    {
	System.out.println("D");
    }
    
}