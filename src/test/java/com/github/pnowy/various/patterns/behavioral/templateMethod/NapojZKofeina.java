import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class NapojZKofeina {

	final void recepturaParzenia() {
		gotowanieWody();
		zaparzanie();
		nalewanieDoFilizanki();
		if (czyKlientChceDodatki()) {
			domieszanieDodatkow();
		}
	}

	abstract void zaparzanie();

	abstract void domieszanieDodatkow();

	void gotowanieWody() {
		System.out.println("gotowanie wody");
	}

	void nalewanieDoFilizanki() {
		System.out.println("nalewanie do filiżanki");
	}

	boolean czyKlientChceDodatki() {
		String odp = getUserInput();
		if (odp.toLowerCase().equalsIgnoreCase("t"))
			return true;
		else 
			return false;
	}

	private String getUserInput() {
		String odpowiedz = null;
		System.out.println("chcesz cukier??");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			odpowiedz = in.readLine();
		} catch (Exception e) {
		}
		if (odpowiedz == null) {
			return "nie";
		}
		return odpowiedz;
	}

}
