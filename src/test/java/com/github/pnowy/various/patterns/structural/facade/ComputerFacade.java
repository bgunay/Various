package com.github.pnowy.various.patterns.structural.facade;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 30.05.13 15:04
 */
public class ComputerFacade {
	private CPU processor;
	private Memory ram;
	private HardDrive hdd;

	public ComputerFacade()
	{
		this.processor = new CPU();
		this.ram = new Memory();
		this.hdd = new HardDrive();
	}

	public void start()
	{
		processor.freeze();
		ram.load(15l, hdd.read(8, 95));
		processor.jump(454);
		processor.execute();
	}

}
