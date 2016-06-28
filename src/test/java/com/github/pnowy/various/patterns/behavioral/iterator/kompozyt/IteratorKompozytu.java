package com.github.pnowy.various.patterns.behavioral.iterator.kompozyt;

import java.util.Iterator;
import java.util.Stack;

public class IteratorKompozytu implements Iterator<MenuSkladnik>
{
    Stack<Iterator<MenuSkladnik>> stos = new Stack<Iterator<MenuSkladnik>>();

    // przekazujemy iterator najwyższego poziomu iterowanego kompozytu
    // zostaje on umieszczony w strukturze typu stos
    public IteratorKompozytu(Iterator<MenuSkladnik> i)
    {
	stos.push(i);
    }

    public boolean hasNext()
    {
	// aby sprawdzić czy istnieje kolejny element wer. stan stosu
	// jeżeli jest on pusty nie ma takiego elementu
	if (stos.empty())
	{
	    return false;
	}
	else
	{
	    // jeżeli stos nie jest pusty pobieramy z niego iterator i
	    // sprawdzamy
	    // czy ten kolejny element.
	    // jeżeli nie, usuwamy go ze stosu i ponownie wywołujemy hasNext()
	    Iterator<MenuSkladnik> i = stos.peek();
	    if (!i.hasNext())
	    {
		stos.pop();
		return hasNext();
	    }
	    else
	    {
		// w pozostałych przypadkach kolejny element
		// istnieje, więc zwracaną wartością jest true
		return true;
	    }
	}
    }

    public MenuSkladnik next()
    {
	if (hasNext())
	{
	    Iterator<MenuSkladnik> i = stos.peek();
	    MenuSkladnik ms = i.next();
	    if (ms instanceof Menu)
	    {
		stos.push(ms.utworzIterator());
	    }
	    return ms;
	}
	else
	    return null;
    }

    public void remove()
    {
	throw new UnsupportedOperationException();
    }

}
