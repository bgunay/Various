package pl.jvsystem.patterns.behavioral.command.designpatterns;
/** CONCRETE COMMAND **/
public class PolecenieWlaczSwiatlo implements Polecenie
{
    Swiatlo swiatlo;

    public PolecenieWlaczSwiatlo(Swiatlo swiatlo)
    {
		this.swiatlo = swiatlo;
    }

    public void wykonaj()
    {
	swiatlo.wlacz();
    }

    public void wycofaj()
    {
	swiatlo.wylacz();
    }

}
