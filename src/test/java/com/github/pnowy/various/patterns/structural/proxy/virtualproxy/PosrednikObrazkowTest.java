package com.github.pnowy.various.patterns.structural.proxy.virtualproxy;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PosrednikObrazkowTest
{
	public static void main(String[] args) throws Exception
	{
		new PosrednikObrazkowTest();
	}

	public PosrednikObrazkowTest() throws Exception
	{
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		f.add(p);
		f.setSize(600, 600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Icon i = new PosrednikObrazow(new URL("http://img149.imageshack.us/img149/7295/kot17me.jpg"));
		JLabel l = new JLabel(i);
		p.add(l);
	}

}
