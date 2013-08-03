package pl.jvsystem.patterns.behavioral.command.designpatterns;

public class MakroPolecenie implements Polecenie
{
    private Polecenie[] polecenia;

    public MakroPolecenie(Polecenie[] p)
    {
	this.polecenia = p;
    }

    public void wycofaj()
    {
	for (Polecenie p : polecenia)
	{
	    p.wykonaj();
	}
    }

    public void wykonaj()
    {
	for (Polecenie p : polecenia)
	{
	    p.wycofaj();
	}
    }

}
