package com.github.pnowy.various.patterns.behavioral.command.designpatterns;

public class MiniPilotTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MiniPilot mp = new MiniPilot();
		Swiatlo s = new Swiatlo();
		PolecenieWlaczSwiatlo p = new PolecenieWlaczSwiatlo(s);
		mp.ustawPolecenie(p);
		mp.przyciskZostalNacisniety();
	}

}
