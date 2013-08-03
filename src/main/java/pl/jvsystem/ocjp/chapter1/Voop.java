package pl.jvsystem.ocjp.chapter1;

public class Voop
{
    Boolean[] b[];
    
    public static void main(String[] args)
    {
	doStuff(1);
	doStuff(1,2);
    }
    static void doStuff(int...doArgs) {}
}

class Voopee extends Voop
{
    static void doStuff(int...doArgs) {}    
}
