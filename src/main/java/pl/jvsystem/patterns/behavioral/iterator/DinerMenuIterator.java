package pl.jvsystem.patterns.behavioral.iterator;

import pl.jvsystem.patterns.behavioral.iterator.PozycjaMenu;

import java.util.Iterator;


public class DinerMenuIterator implements Iterator<PozycjaMenu>
{
	PozycjaMenu[] elementy;
	int pozycja = 0;

	public DinerMenuIterator(PozycjaMenu[] e)
	{
		this.elementy = e;
	}

	@Override
	public boolean hasNext()
	{
		if (pozycja >= elementy.length || elementy[pozycja] == null)
		{
			return false;
		}
		return true;
	}

	@Override
	public PozycjaMenu next()
	{
		PozycjaMenu pm = elementy[pozycja];
		pozycja++;
		return pm;
	}

	@Override
	public void remove()
	{
		if (pozycja <= 0)
		{
			throw new IllegalStateException("nie można usunąć elementu przed pierwszym wywołaniem");
		}
		if (elementy[pozycja - 1] != null)
		{
			for (int i = pozycja - 1; i < (elementy.length - 1); i++)
			{
				elementy[i] = elementy[i + 1];
			}
		}
	}

}
