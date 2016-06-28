
public class Kawa extends NapojZKofeina {

	@Override
	void domieszanieDodatkow() {
		System.out.println("dodawanie cukru oraz mleka");
	}

	@Override
	void zaparzanie() {
		System.out.println("zaparzanie i przesączanie przez filtr");
	}
	
	boolean czyKlientChceDodatki() {
		return false;
	}
}
