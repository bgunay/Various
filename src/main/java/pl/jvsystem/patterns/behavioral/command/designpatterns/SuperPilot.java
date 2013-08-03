package pl.jvsystem.patterns.behavioral.command.designpatterns;

public class SuperPilot {
	Polecenie[] poleceniaWlacz;
	Polecenie[] poleceniaWylacz;
	Polecenie polecenieWycofaj;
	
	public SuperPilot() {
		poleceniaWlacz = new Polecenie[2];
		poleceniaWylacz = new Polecenie[2];
		
		Polecenie brakPolecenia = new BrakPolecenia();
		for(int i=0;i<2;i++) {
			poleceniaWlacz[i] = brakPolecenia;
			poleceniaWylacz[i] = brakPolecenia;
		}
		polecenieWycofaj = brakPolecenia;
	}
	
	public void wcisnietoPrzyciskWlacz(int slot) {
		poleceniaWlacz[slot].wykonaj();
		polecenieWycofaj = poleceniaWlacz[slot];
	}
	
	public void wcisnietoPrzyciskWylacz(int slot) {
		poleceniaWylacz[slot].wykonaj();
		polecenieWycofaj = poleceniaWylacz[slot];
	}
	
	public void ustawPoleceni(int slot,Polecenie polecenieWlacz,Polecenie polecenieWylacz) {
		poleceniaWlacz[slot] = polecenieWlacz;
		poleceniaWylacz[slot] = polecenieWylacz;
	}
	
	public void wcisnietoPrzyciskWycofaj() {
		polecenieWycofaj.wycofaj();
	}
	
}
