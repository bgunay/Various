package pl.jvsystem.ocjp.chapter7;

import java.util.HashMap;
import java.util.Map;

public class MapEQ
{

    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
	String a = "abc";
	String b = "abc";
	System.out.println(a==b);
//	Map<ToDos, String> m = new HashMap<ToDos, String>();
//	ToDos t1 = new ToDos("Monday");
//	ToDos t2 = new ToDos("Monday");
//	System.out.println(t1.equals(t2));
//	ToDos t3 = new ToDos("Tuesday");
//	m.put(t1, "doLaundry");
//	m.put(t2, "payBills");
//	m.put(t3, "cleanAttic");
//	System.out.println(m.size());
    }

}

class ToDos 
{
    String day;
    
    public ToDos(String d)
    {
	this.day = d;
    }
    
    public boolean equals(Object o)
    {
	return ((ToDos)o).day == this.day;
    }
    public int hashCode() { return 9; }
}