package pl.jvsystem.patterns.structural.proxy.headfirst;

public class StanNieMaMonety implements Stan {
	AutomatSprzedajacy automat;
	
	public StanNieMaMonety(AutomatSprzedajacy a) {
		this.automat = a;
	}
	
	@Override
	public void przekrecGalke() {
		System.out.println("Zanim przekręcisz gałkę wrzuć monete");
	}

	@Override
	public void wlozMonete() {
		System.out.println("Moneta przyjęta");
		automat.ustawStan(automat.pobierzStanJestMoneta());
	}

	@Override
	public void wydaj() {
		System.out.println("Najpierw zapłać");
	}

	@Override
	public void zwrocMonete() {
		System.out.println("nie włożyłeś monety");
	}
	
}
