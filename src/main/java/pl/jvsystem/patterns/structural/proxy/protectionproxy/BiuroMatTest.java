package pl.jvsystem.patterns.structural.proxy.protectionproxy;

import java.lang.reflect.Proxy;

public class BiuroMatTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		BiuroMatTest b = new BiuroMatTest();
		b.testuj();

	}

	public void testuj()
	{
		OsobaKomponent jasiu = new OsobaKomponentImpl();
		jasiu.ustawImie("Jan");
		jasiu.ustawPlec("M");
		jasiu.ustawZainteresowania("woda");
		OsobaKomponent posrednikWlasciciela = pobierzPosrednikWlasciciela(jasiu);
		System.out.println("" + posrednikWlasciciela.pobierzImie());
		jasiu.ustawZainteresowania("ogień");
		System.out.println("" + jasiu.pobierzZainteresowania());
		posrednikWlasciciela.ustawRankingUrody(3);
	}

	OsobaKomponent pobierzPosrednikWlasciciela(OsobaKomponent o)
	{
		return (OsobaKomponent) Proxy.newProxyInstance(
				o.getClass().getClassLoader(),
				o.getClass().getInterfaces(),
				new InvocationHandlerWlasciciela(o));
	}

}
