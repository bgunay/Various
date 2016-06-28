package com.github.pnowy.various.patterns.behavioral.mediator;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 01.06.13 21:22
 */
class BtnSearch extends JButton implements Command
{
	IMediator med;

	BtnSearch(ActionListener al, IMediator m)
	{
		super("Search");
		addActionListener(al);
		med = m;
		med.registerSearch(this);
	}

	public void execute()
	{
		med.search();
	}

}
