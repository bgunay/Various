package pl.jvsystem.patterns.behavioral.mediator;

import javax.swing.*;
import java.awt.*;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 01.06.13 21:25
 */
class LblDisplay extends JLabel
{
	IMediator med;

	LblDisplay(IMediator m)
	{
		super("Just start...");
		med = m;
		med.registerDisplay(this);
		setFont(new Font("Arial", Font.BOLD, 24));
	}

}
