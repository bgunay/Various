package pl.jvsystem.patterns.structural.proxy.headfirst;


public class StanBrakGum implements Stan
{
	AutomatSprzedajacy automat;
	
	public StanBrakGum(AutomatSprzedajacy a) {
		this.automat=a;
	}
	
	@Override
	public void przekrecGalke() {
		System.out.println("przekręciłeś gałkę ale automat jest pusty");
	}

	@Override
	public void wlozMonete() {
		System.out.println("automat jest pusty");
	}

	@Override
	public void wydaj() {
		System.out.println("nie wydano gumy");
	}

	@Override
	public void zwrocMonete() {
		System.out.println("nie ma monety");
	}

}
