
import com.github.pnowy.various.patterns.behavioral.iterator.kompozyt.MenuSkladnik;

import java.util.Iterator;

public class Kelner2 {
	MenuSkladnik wszystkie;
	
	public Kelner2(MenuSkladnik ms) {
		this.wszystkie=ms;
	}
	
	public void drukujMenu() {
		wszystkie.drukuj();
	}
	// metoda pobiera iterator kompozytu
	public void drukujMenuWegetarianskie() {
		Iterator<MenuSkladnik> i = wszystkie.utworzIterator();
		while (i.hasNext()) {
			MenuSkladnik ms = i.next();
			// jeżeli dany element zwraca war. true wywołujemy met. drukuj
			try {
				if (ms.isWegetarianska())
					ms.drukuj();
			} catch (UnsupportedOperationException e) {}
		}
	}
	
}
