package pl.jvsystem.patterns.behavioral.iterator;

public class PozycjaMenu
{
	private String nazwa;
	private String opis;
	private boolean wegetarianska;
	private double cena;

	public PozycjaMenu(String n, String o, boolean w, double c)
	{
		this.nazwa = n;
		this.opis = o;
		this.wegetarianska = w;
		this.cena = c;
	}

	public String getNazwa()
	{
		return nazwa;
	}

	public void setNazwa(String nazwa)
	{
		this.nazwa = nazwa;
	}

	public String getOpis()
	{
		return opis;
	}

	public void setOpis(String opis)
	{
		this.opis = opis;
	}

	public boolean isWegetarianska()
	{
		return wegetarianska;
	}

	public void setWegetarianska(boolean wegetarianska)
	{
		this.wegetarianska = wegetarianska;
	}

	public double getCena()
	{
		return cena;
	}

	public void setCena(double cena)
	{
		this.cena = cena;
	}

	@Override
	public String toString()
	{
		return "PozycjaMenu [cena=" + cena + ", nazwa=" + nazwa + ", opis="
				+ opis + ", wegetarianska=" + wegetarianska + "]";
	}

}
