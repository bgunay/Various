package pl.jvsystem.patterns.behavioral.observer.mypattern;

public class Main
{

	public static void main(String[] args)
	{
		Package p = new Package();
		PackageElement pe1 = new PackageElement();
		PackageElement pe2 = new PackageElement();
		p.registerObserver(pe1);
		p.registerObserver(pe2);
		p.notifyObservers();
	}

}
