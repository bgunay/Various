package pl.jvsystem.patterns.structural.proxy.headfirst;

public class StanWygrana implements Stan {
	AutomatSprzedajacy automat;
	
	public StanWygrana(AutomatSprzedajacy a) {
		this.automat = a;
	}
	
	@Override
	public void przekrecGalke() {
		System.out.println("nie można przekręcić gałki - stan wygrana");
	}

	@Override
	public void wlozMonete() {
		System.out.println("nie można włożyć monety - stan wygrana");
	}

	@Override
	public void wydaj() {
		System.out.println("wygrałeś!!! dostajesz 2 gume");
		automat.zwolnijGume();
		if (automat.liczba==0) {
			automat.ustawStan(automat.pobierzStanBrakGum());
		} else {
			automat.zwolnijGume();
			if (automat.liczba>0) {
				automat.ustawStan(automat.pobierzStanNieMaMonety());
			} else {
				System.out.println("ups, koniec gum");
				automat.ustawStan(automat.pobierzStanBrakGum());
			}
		}
	}

	@Override
	public void zwrocMonete() {
		System.out.println("stan wygrana, nie można zwrócić monety");
	}

}
