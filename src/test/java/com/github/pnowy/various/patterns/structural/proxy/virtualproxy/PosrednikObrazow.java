package com.github.pnowy.various.patterns.structural.proxy.virtualproxy;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PosrednikObrazow implements Icon
{
	ImageIcon imageIcon;
	URL obrazekURL;
	Thread pobieranieThread;
	boolean pobieranie;

	public PosrednikObrazow(URL url)
	{
		this.obrazekURL = url;
	}

	@Override
	public int getIconHeight()
	{
		if (imageIcon != null)
		{
			return imageIcon.getIconHeight();
		}
		else
		{
			return 600;
		}
	}

	@Override
	public int getIconWidth()
	{
		if (imageIcon != null)
		{
			return imageIcon.getIconWidth();
		}
		else
		{
			return 800;
		}
	}

	@Override
	public void paintIcon(final Component arg0, Graphics g, int x, int y)
	{
		if (imageIcon != null)
		{
			imageIcon.paintIcon(arg0, g, x, y);
		}
		else
		{
			g.drawString("Trwa ładowanie okładki, proszę czekać...", x + 300, y + 190);
			if (!pobieranie)
			{
				pobieranie = true;
				pobieranieThread = new Thread(new Runnable()
				{

					@Override
					public void run()
					{
						try
						{
							imageIcon = new ImageIcon(obrazekURL, "Okładka CD");
							arg0.repaint();
						}
						catch (Exception e)
						{
							e.printStackTrace();
						}
					}
				});
				pobieranieThread.start();
			}
		}
	}

}
