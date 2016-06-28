package com.github.pnowy.various.patterns.behavioral.observer.mypattern;

import java.util.ArrayList;

/**
 * Paczka implementująca interfejs podmiotu.
 * Elementy paczki są powiadamiane w razie zmian.
 */
public class Package implements Observed<UpdateBean>
{
	private ArrayList<Observer<UpdateBean>> observers;

	public Package()
	{
		observers = new ArrayList<Observer<UpdateBean>>();
	}

	@Override
	public void deleteObserver(Observer<UpdateBean> o)
	{
		observers.remove(o);
	}

	@Override
	public void registerObserver(Observer<UpdateBean> o)
	{
		observers.add(o);
	}

	@Override
	public void notifyObservers()
	{
		UpdateBean ub = new UpdateBean();
		for (Observer<UpdateBean> o : observers)
		{
			o.update(ub);
		}
	}

}