package com.github.pnowy.various.ocjp.chapter3;

public class CastingTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
//	float f = 234.56F;
//	short s = (short)f;
//	System.out.println(s);
//	new CastingTest().go(new String[] {"a"});
//	new CastingTest().invade(7);
    }
    
    public void go(String[] args)
    {
	
    }
    
    String invade(short ships) { return "a few"; }
    String invade(short... ships) { return "many"; }

}
