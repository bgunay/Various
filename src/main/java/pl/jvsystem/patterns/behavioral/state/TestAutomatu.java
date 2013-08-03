package pl.jvsystem.patterns.behavioral.state;

public class TestAutomatu
{

	public static void main(String[] args)
	{
		AutomatSprzedajacy a = new AutomatSprzedajacy(3);
		System.out.println(a);
		a.wlozMonete();
		a.przekrecGalke();
		a.wlozMonete();
		a.wlozMonete();
		a.przekrecGalke();
		System.out.println(a);
	}

}
