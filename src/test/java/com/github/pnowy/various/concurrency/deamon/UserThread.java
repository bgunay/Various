package com.github.pnowy.various.concurrency.deamon;

class UserThread implements Runnable {
	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("User thread is running");
				Thread.sleep(1000);
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();

		} finally {
			System.out.println("User Thread exiting");
		}
	}
}
