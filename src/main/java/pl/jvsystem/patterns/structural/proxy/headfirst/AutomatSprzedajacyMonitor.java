package pl.jvsystem.patterns.structural.proxy.headfirst;

public class AutomatSprzedajacyMonitor {
	AutomatSprzedajacy automat;
	
	public AutomatSprzedajacyMonitor(AutomatSprzedajacy a) {
		this.automat = a;
	}
	
	public void raport() {
		System.out.println("Automat: "+automat.pobierzLokalizacja());
		System.out.println("Towar: "+automat.liczba);
		System.out.println("Stan: "+automat.stan);
	}
	
}
