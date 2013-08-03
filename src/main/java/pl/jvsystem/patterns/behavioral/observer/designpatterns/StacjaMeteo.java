package pl.jvsystem.patterns.behavioral.observer.designpatterns;

public class StacjaMeteo
{
    public static void main(String... strings)
    {
	DanePogodowe dp = new DanePogodowe();
	WarunkiBiezaceWyswietl wb = new WarunkiBiezaceWyswietl(dp);
	dp.ustawOdczyty(10.3f, 34f, 45.6f);
	dp.ustawOdczyty(34f, 22.2f, 45.4f);
    }
}
