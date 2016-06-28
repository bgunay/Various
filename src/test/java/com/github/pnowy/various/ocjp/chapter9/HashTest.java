package com.github.pnowy.various.ocjp.chapter9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;

public class HashTest
{

    private String str;

    public HashTest(String str)
    {
	this.str = str;
    }

    @Override
    public String toString()
    {
	return str;
    }

    @Override
    public int hashCode()
    {
	return this.str.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
	if (obj instanceof HashTest)
	{
	    HashTest ht = (HashTest) obj;
	    return this.str.equals(ht.str);
	}
	return false;
    }

    public static void main(String args[])
    {
	HashTest h1 = new HashTest("1");
	HashTest h2 = new HashTest("1");
	String s1 = new String("2");
	String s2 = new String("2");

	HashSet<Object> hs = new HashSet<Object>();
	hs.add(h1);
	hs.add(h2);
	hs.add(s1);
	hs.add(s2);

//	System.out.print(hs.size());
	
//	test(new String[] {"a", "b"});
	String a = "krowa";
	System.out.println(a.substring(1, 3));
	System.out.println(a.charAt(1));
	System.out.println(a.concat(" jadźka"));
	System.out.println(a.replace('k', 'm'));
	StringBuilder sb = new StringBuilder("byk");
//	sb.delete(1, 2);
	sb.reverse();
	System.out.println(sb);
	try
	{
	    PrintWriter pw = new PrintWriter(new File(""));
	    
	}
	catch (FileNotFoundException e)
	{
	    
	}
	
//	DateFormat df = DateFormat.getDa
	
//	try
//	{
//	    FileOutputStream os = new FileOutputStream("data.dat");
//	    ObjectOutputStream oos = new ObjectOutputStream(os);
//	    oos.writeObject(a);
//	    oos.close();
//	}
//	catch (IOException e)
//	{
//	    e.printStackTrace();
//	}
//	
//	OuterClass oc = new OuterClass();
//	OuterClass.InnerClass in = oc.new InnerClass();
	
	
    }
    
    public static void test(String[]... t)
    {
	
    }
}

class OuterClass
{
    class InnerClass
    {
	
    }
}