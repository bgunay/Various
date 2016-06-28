package com.github.pnowy.various.ocjp.chapter10;

import com.github.pnowy.various.ocjp.chapter1.TestInterface;

public class StatTestExtend extends StatTest implements TestInterface
{

    public static void main(String[] args)
    {
	StatTestExtend e = new StatTestExtend();
	e.go();
    }

}