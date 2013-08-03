package pl.jvsystem.ocjp.chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class A {}
class B extends A {}

public class Comp2
{

    public static void main(String[] args)
    {
//	float f1 = 2.3f;
//	float[][] f2 = { {42.5f}, {1.7f, 2.3f}, {2.6f, 2.7f} };
//	float[] f3 = {2.7f};
//	Long x = 32l;
//	if (x == f2[0][0])
//	    System.out.println("true");
//    
//	A a = new A();
//	B b = new B();
//	Integer.parseInt("dsfds" +
//			"" +
//			"");
//	
//	for(int y=0,  z=0;z<5; z++)
//	{
//	    
//	}
//
//	NumberFormat nf  = NumberFormat.getInstance();
//	try
//	{
//	    nf.parse("");
//	}
//	catch (ParseException e)
//	{
//	    // TODO Auto-generated catch block
//	    e.printStackTrace();
//	}
//	
//	Short aaa = 35;
//	byte x =0;
//	byte y = 2;
////	byte z = x + y;
//	Date d = null;
//	String b = "zakopane";
//	System.out.println(b.substring(2, 4));
//	
//	int  w = 3;
//	int y = 7/w;
//	
////	if (a==b)
////	    System.out.println("");
//	
//	Integer integ = 15;
//	Long lon = new Long(23);
	
//	if (integ==lon)
//	    System.out.println("ee");
	
	C c = new C();
	D d = new D();
	A a = new A();
	if (c==d)
	    System.out.println("");
//	if (d==a)
//	    System.out.println("");
	List<A> al = new ArrayList<A>();
	al.add(new B());
	Set set = new TreeSet();
	set.add("1");
	set.add(2);
	set.add("3");
	
    }

}

class C {}
class D extends C {}
