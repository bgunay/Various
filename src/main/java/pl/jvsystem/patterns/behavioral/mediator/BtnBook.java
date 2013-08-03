package pl.jvsystem.patterns.behavioral.mediator;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 01.06.13 21:24
 */
class BtnBook extends JButton implements Command
{
	IMediator med;

	BtnBook(ActionListener al, IMediator m)
	{
		super("Book");
		addActionListener(al);
		med = m;
		med.registerBook(this);
	}

	public void execute()
	{
		med.book();
	}

}
