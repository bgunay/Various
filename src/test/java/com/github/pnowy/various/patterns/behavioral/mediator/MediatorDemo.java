package com.github.pnowy.various.patterns.behavioral.mediator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 01.06.13 21:27
 */
class MediatorDemo extends JFrame implements ActionListener
{

	IMediator med = new Mediator();

	MediatorDemo()
	{
		JPanel p = new JPanel();
		p.add(new BtnView(this, med));
		p.add(new BtnBook(this, med));
		p.add(new BtnSearch(this, med));
		getContentPane().add(new LblDisplay(med), "North");
		getContentPane().add(p, "South");
		setSize(400, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		Command comd = (Command) ae.getSource();
		comd.execute();
	}

	public static void main(String[] args)
	{
		new MediatorDemo();
	}

}
