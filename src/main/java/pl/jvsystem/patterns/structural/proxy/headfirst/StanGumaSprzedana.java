package pl.jvsystem.patterns.structural.proxy.headfirst;

public class StanGumaSprzedana implements Stan {
	AutomatSprzedajacy automat;
	
	public StanGumaSprzedana(AutomatSprzedajacy a) {
		this.automat=a;
	}
	
	@Override
	public void przekrecGalke() {
		System.out.println("nie dostaniesz gumy za drugie przekręcenie");
	}

	@Override
	public void wlozMonete() {
		System.out.println("nie można zwrócić monety po przekręceniu gałki");
	}

	@Override
	public void wydaj() {
		automat.zwolnijGume();
		if (automat.liczba > 0) {
			automat.ustawStan(automat.pobierzStanNieMaMonety());
		} else {
			System.out.println("koniec gum");
			automat.ustawStan(automat.pobierzStanBrakGum());
		}
	}

	@Override
	public void zwrocMonete() {
		System.out.println("nie można zwrócić monety po przekręceniu gałki");
	}

}
