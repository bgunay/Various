package pl.jvsystem.ocjp.chapter2;

class Dog
{
    public void bark() { System.out.println("woof"); }
}

class Hound extends Dog
{

    @Override
    public void bark()
    {
	System.out.println("howl");
    }
    
    public void sniff() { System.out.println("sniff"); }
    
}

public class DogShow
{

    public static void main(String[] args)
    {
//	new DogShow().go();
	String[][] a = {{"a"}, {"źb"}};
	String[] b = {"a", "źb"};
	new DogShow().test(a);
    }
    
    void go()
    {
	new Hound().bark();
	((Dog)new Hound()).bark();
//	((Dog)new Hound()).sniff();
    }
    
    void test(String[]...arg)
    {
	System.out.println(arg.getClass().getName());
    }

}