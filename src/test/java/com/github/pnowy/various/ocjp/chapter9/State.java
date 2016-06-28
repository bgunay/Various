package com.github.pnowy.various.ocjp.chapter9;

import java.io.IOException;
import java.util.Formatter;
import java.util.NavigableMap;

//import com.github.pnowy.various.ocjp.chapter9.State.Util;

public class State
{

    public enum Util {
	IN, OUT
    }
}

class StateTest
{
    public static void main(String... strings) throws IOException
    {
//	FileWriter fw = new FileWriter(new File(""));
	
//	BufferedReader br = new BufferedReader(new FileReader(new File("")));
//	BufferedWriter bw = new BufferedWriter(new FileWriter(new File("")));
	Formatter f = new Formatter();
	
//	System.out.println(f.format("%4.8f", -25f));
	State.Util u = State.Util.OUT;
	System.out.println(u.ordinal());
	NavigableMap<String, Integer> nmMap;
	
    }
}
//
//class ExceptionTest
//{
//    public static void main(String... strings)
//    {
//	File f = new File("");
//	
//    }
//}
