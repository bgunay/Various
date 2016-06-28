package com.github.pnowy.various.patterns.behavioral.strategy.designpatterns;

public class ModelKaczki extends Kaczka
{

    public ModelKaczki()
    {
	latanieInterfejs = new NieLatam();
	kwakanieInterfejs = new Kwacz();
    }

    @Override
    public void wyswietl()
    {
	System.out.println("Jestem modelem kaczki");
    }

}
