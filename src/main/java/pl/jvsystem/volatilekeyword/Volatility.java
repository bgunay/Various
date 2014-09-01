package pl.jvsystem.volatilekeyword;

/**
 * Volatility
 */
public class Volatility {

	static int NEXT_IN_LINE = 0;
//	volatile static int NEXT_IN_LINE = 0; // <- this is the difference

	public static void main(String[] args) {
		new CustomerInLine().start();
		new Queue().start();
	}

	static class CustomerInLine extends Thread {
		@Override
		public void run() {
			while(true) {
				if (NEXT_IN_LINE>=4) {
					break;
				}
			}
			System.out.format("Great, finally #%d wass called, now it is my turn\n", NEXT_IN_LINE);
		}
	}

	static class Queue extends Thread {
		@Override
		public void run() {
			while(NEXT_IN_LINE<11) {
				System.out.format("Calling for the customer #%d\n", NEXT_IN_LINE++);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
