package com.github.pnowy.various.patterns.behavioral.mediator;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 01.06.13 21:21
 */
class BtnView extends JButton implements Command
{
	IMediator med;

	BtnView(ActionListener al, IMediator m)
	{
		super("View");
		addActionListener(al);
		med = m;
		med.registerView(this);
	}

	public void execute()
	{
		med.view();
	}

}
