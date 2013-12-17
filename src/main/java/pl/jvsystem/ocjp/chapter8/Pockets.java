package pl.jvsystem.ocjp.chapter8;

import java.util.Comparator;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public class Pockets
{

    public static void main(String[] args)
    {
	Stopwatch s = Stopwatch.createStarted();
	
	System.out.println(s.elapsed(TimeUnit.MILLISECONDS));
	
	System.out.println(s.isRunning());
	
	String[] sa = {"nickel", "button", "key", "lint"};
//	Sorter s = new Pockets().new Sorter();
	try
	{
	    Thread.sleep(400);
	}
	catch (InterruptedException e)
	{
	    e.printStackTrace();
	}
    }
    
    public void go()
    {
	Sorter s = new Sorter();
    }

    class Sorter implements Comparator<String>
    {

	@Override
	public int compare(String a, String b)
	{
	    return b.compareTo(a);
	}
	
    }
    
}
