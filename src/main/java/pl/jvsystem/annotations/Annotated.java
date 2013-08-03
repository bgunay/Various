package pl.jvsystem.annotations;

/**
 * Created with IntelliJ IDEA.
 * User: DELL
 * Date: 01.02.13
 * Time: 22:29
 */
public class Annotated
{
	@Test(info = "awesome")
	public void foo(String myParam)
	{
		System.out.println("This is my param:"+myParam);
	}
}
