package com.github.pnowy.various.ocjp.chapter9;

class Alfa
{
    private int over = 1;
//    
//    public static void main(String...strings)
//    {
//	String s = "wbeekeeper";
//	System.out.println(s.substring(1, 7));
//	System.out.println(go(2));
////	Alfa a = new Gamma();
////	System.out.println(a.over);
////	System.out.println(currentTimeMillis());
//	System.out.println(Thread.MAX_PRIORITY);
//    }
    
    public static int go(int x)
    {
	return x++;
    }
    public <S extends CharSequence> S go2(S x)
    {
	return null;
    }
    
}

class High
{
    public static int go(int...is) {
	return 13;
    }
}

class Low extends High
{
    public static int go(Integer a, Integer b)
    {
	return 15;
    }
    
    public static void main(String...strings)
    {
	String ab = "twoja";
	System.out.println(ab.concat(" mać"));
    }
    
//    static void basket(List<?> in)
//    {
//	in.add(new High());
//    }
//    
    protected void finalize()
    {
//	super.finalize();
    }
    
}

class Gamma extends Beta
{
    private int over =3;
}

public class GammaTest
{

//    public static void main(String[] args)
//    {
//	Alfa a = new Gamma();
////	System.out.println();
//    }

}
