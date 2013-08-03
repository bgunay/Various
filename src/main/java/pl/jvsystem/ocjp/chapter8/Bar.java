package pl.jvsystem.ocjp.chapter8;

class Boo
{
    Boo(String s) { System.out.println("boo with s"); }
//    Boo() { System.out.println("boo"); }
}

public class Bar extends Boo
{
//    Bar() { System.out.println("bar"); }
    Bar(String s) { super(s); System.out.println("bar with s"); }
    
    public static void main(String...args)
    {
	new Bar("a");
    }
    
}
