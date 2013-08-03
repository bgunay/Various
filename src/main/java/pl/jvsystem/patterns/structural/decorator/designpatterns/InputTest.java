package pl.jvsystem.patterns.structural.decorator.designpatterns;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
	int c;
	try
	{
	    InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("c:/test.txt")));
	    while ((c = in.read()) >= 0)
	    {
		System.out.print((char) c);
	    }
	} catch (IOException e)
	{
	    e.printStackTrace();
	}
    }

}
