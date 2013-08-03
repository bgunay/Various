package pl.jvsystem.ocjp.chapter9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GerbitTest
{

    public static void main(String[] args)
    {
	File f = new File("c:\\test.txt");
	
	try
	{
	    FileWriter fw = new FileWriter(f);
	    Float.parseFloat("invalid");
	    
	}
	catch (IOException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public void parse(String in)
    {
	try
	{
	    float f = Float.parseFloat(in);
	}
	catch (NumberFormatException e)
	{
	}
    }
    
}

class Animal
{
}

class Gerbit extends Animal
{
}

class Vet
{
    protected String name;
    Animal go()
    {
	return new Animal();
    };
}

class SmallVet extends Vet
{
    Gerbit go()
    {
	String s = super.name;
	return new Gerbit();
    };
}