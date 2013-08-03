package pl.jvsystem.patterns.structural.proxy.protectionproxy;

public interface OsobaKomponent
{
	String pobierzImie();

	String pobierzPlec();

	String pobierzZainteresowania();

	int pobierzRankingUrody();

	void ustawImie(String nazwa);

	void ustawPlec(String plec);

	void ustawZainteresowania(String zainteresowania);

	void ustawRankingUrody(int ranking);
}
