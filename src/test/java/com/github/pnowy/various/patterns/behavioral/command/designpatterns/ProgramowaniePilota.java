package com.github.pnowy.various.patterns.behavioral.command.designpatterns;

public class ProgramowaniePilota
{
    public static void main(String[] args)
    {
	SuperPilot sp = new SuperPilot();
	sp.ustawPoleceni(0, new PolecenieWlaczSwiatlo(new Swiatlo()), new PolecenieWylaczSwiatlo(new Swiatlo()));
	sp.wcisnietoPrzyciskWlacz(0);
	sp.wcisnietoPrzyciskWycofaj();
    }
}
