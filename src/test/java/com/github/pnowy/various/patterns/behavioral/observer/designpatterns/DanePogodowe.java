package com.github.pnowy.various.patterns.behavioral.observer.designpatterns;

import java.util.Observable;

/*
 * To jest wersja napisana przeze mnie.
 */
//public class DanePogodowe implements Podmiot {
//	private ArrayList<Obserwator> obserwatorzy;
//	private float temp;
//	private float cisnienie;
//	private float wilgotnosc;
//	
//	public DanePogodowe() {
//		obserwatorzy = new ArrayList<Obserwator>();
//	}
//	
//	@Override
//	public void powiadomObserwatorow() {
//		for(Obserwator o : obserwatorzy) {
//			o.aktualizacja(temp, wilgotnosc, cisnienie);
//		}
//	}
//
//	@Override
//	public void usunObserwatora(Obserwator o) {
//		int i = obserwatorzy.indexOf(o);
//		if (i > 0) {
//			obserwatorzy.remove(i);
//		}
//	}
//
//	@Override
//	public void zarejestrujObserwatora(Obserwator o) {
//		obserwatorzy.add(o);
//	}
//	
//	public void odczytyZmiana() {
//		powiadomObserwatorow();
//	}
//	
//	public void ustawOdczyty(float temp, float cisnienie, float wilgotnosc) {
//		this.temp = temp;
//		this.cisnienie = cisnienie;
//		this.wilgotnosc = wilgotnosc;
//		odczytyZmiana();
//	}
//}

public class DanePogodowe extends Observable
{
    private float temp;
    private float cisnienie;
    private float wilgotnosc;

    public DanePogodowe()
    {
    }

    public void odczytyZmiana()
    {
	setChanged();
	notifyObservers();
    }

    public void ustawOdczyty(float temp, float cisnienie, float wilgotnosc)
    {
	this.temp = temp;
	this.cisnienie = cisnienie;
	this.wilgotnosc = wilgotnosc;
	odczytyZmiana();
    }

    public float pobierzTemp()
    {
	return temp;
    }

    public float pobierzWilgotnosc()
    {
	return cisnienie;
    }

    public float pobierzCisnienie()
    {
	return wilgotnosc;
    }

}