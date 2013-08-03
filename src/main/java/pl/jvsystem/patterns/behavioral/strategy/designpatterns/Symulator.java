package pl.jvsystem.patterns.behavioral.strategy.designpatterns;

public class Symulator
{
    public static void main(String... strings)
    {
	Kaczka dzika = new DzikaKaczka();
	dzika.wykonajKwacz();
	dzika.wykonajLec();

	Kaczka model = new ModelKaczki();
	model.wykonajLec();
	model.ustawLatanieInterfejs(new NapedRakietowy());
	model.wykonajLec();
    }
}
