package pl.jvsystem.patterns.behavioral.strategy.designpatterns;

public abstract class Kaczka
{
    // deklaruje dwie zmienne typu interfejsu dla poszczególnych zachowań
    // wszystkie klasy podrzędne będą dziedziczyły te dwie zmienne
    LatanieInterfejs latanieInterfejs;
    KwakanieInterfejs kwakanieInterfejs;

    public abstract void wyswietl();

    public void wykonajLec()
    {
	latanieInterfejs.lec();
    }

    public void wykonajKwacz()
    {
	kwakanieInterfejs.kwacz();
    }

    public void plywaj()
    {
	System.out.println("Wszystkie kaczki pływają (ABSTRACT KACZKA)");
    }

    public void ustawLatanieInterfejs(LatanieInterfejs li)
    {
	this.latanieInterfejs = li;
    }

    public void ustawKwakanieInterfejs(KwakanieInterfejs ki)
    {
	this.kwakanieInterfejs = ki;
    }
}
