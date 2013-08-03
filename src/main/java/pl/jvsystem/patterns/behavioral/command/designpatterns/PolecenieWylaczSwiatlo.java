package pl.jvsystem.patterns.behavioral.command.designpatterns;
/** CONCRETE COMMAND **/
public class PolecenieWylaczSwiatlo implements Polecenie
{
    Swiatlo swiatlo;

    public PolecenieWylaczSwiatlo(Swiatlo swiatlo)
    {
	this.swiatlo = swiatlo;
    }

    public void wycofaj()
    {
	swiatlo.wylacz();
    }

    public void wykonaj()
    {
	swiatlo.wlacz();
    }

}
