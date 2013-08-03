package pl.jvsystem.patterns.behavioral.observer.designpatterns;

import java.util.Observable;
import java.util.Observer;

public class WarunkiBiezaceWyswietl implements Observer, WyswietlElement
{
    private float temp;
    private float wilgotnosc;
    Observable observable;

    public WarunkiBiezaceWyswietl(Observable danPogodowe)
    {
	this.observable = danPogodowe;
	observable.addObserver(this);
    }

    public void wyswietl()
    {
	System.out.println("Warunki bieżące: " + temp + " stopni C oraz " + wilgotnosc + " % wilgotnosc");
    }

    public void update(Observable o, Object arg)
    {
	if (o instanceof DanePogodowe)
	{
	    DanePogodowe dp = (DanePogodowe) o;
	    this.temp = dp.pobierzTemp();
	    this.wilgotnosc = dp.pobierzWilgotnosc();
	    wyswietl();
	}
    }

}