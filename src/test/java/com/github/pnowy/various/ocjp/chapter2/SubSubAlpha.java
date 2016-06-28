package com.github.pnowy.various.ocjp.chapter2;

class Alpha
{
    static String s = "";
    protected Alpha() { s+= "alpha "; }
}

class SubAlpha extends Alpha
{
    SubAlpha() { s += "sub "; }
}

public class SubSubAlpha extends SubAlpha
{

    private SubSubAlpha() { s+= "subsub"; }
    
    public static void main(String[] args)
    {
	new SubSubAlpha();
	System.out.println(s);
    }

}
