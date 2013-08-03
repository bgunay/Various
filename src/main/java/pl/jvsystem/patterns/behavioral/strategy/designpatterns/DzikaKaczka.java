package pl.jvsystem.patterns.behavioral.strategy.designpatterns;

public class DzikaKaczka extends Kaczka
{

    public DzikaKaczka()
    {
	latanieInterfejs = new LatamBoMamSkrzydla();
	kwakanieInterfejs = new Kwacz();
    }

    @Override
    public void wyswietl()
    {
	System.out.println("Dzika kaczka");
    }

}
