package com.github.pnowy.various.ocjp.chapter10;

//import static java.lang.Integer.MAX_VALUE;
import com.github.pnowy.various.ocjp.chapter1.TestInterface;

public class StatTest implements TestInterface
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
	System.out.println(Integer.MAX_VALUE);
	
	int b = MAX_VALUE;
    }

    @Override
    public void go()
    {
	System.out.println("go");
    }

}
