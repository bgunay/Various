package pl.jvsystem.patterns.behavioral.command.designpatterns;

public class MiniPilot {
	Polecenie slot;
	
	public MiniPilot() {}
	
	public void ustawPolecenie(Polecenie p) {
		this.slot = p;
	}
	
	public void przyciskZostalNacisniety() {
		slot.wykonaj();
	}
	
}
