package pl.jvsystem.patterns.structural.decorator.designpatterns;

public abstract class Napoj
{
    String opis = "Nieznany napój";

    public String pobierzOpis()
    {
	return opis;
    }

    public abstract double koszt();
}
