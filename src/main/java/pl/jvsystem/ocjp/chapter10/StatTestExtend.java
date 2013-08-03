package pl.jvsystem.ocjp.chapter10;

import pl.jvsystem.ocjp.chapter1.TestInterface;

public class StatTestExtend extends StatTest implements TestInterface
{

    public static void main(String[] args)
    {
	StatTestExtend e = new StatTestExtend();
	e.go();
    }

}