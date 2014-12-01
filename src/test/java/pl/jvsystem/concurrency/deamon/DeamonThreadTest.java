package pl.jvsystem.concurrency.deamon;

/**
 * DeamonThreadTest
 */
public class DeamonThreadTest {
	public static void main(String[] args) {
		// Create a new daemon thread and start it
		DaemonThread daemonThread = new DaemonThread();
		daemonThread.setDaemon(false); // change to true and check what happens
		daemonThread.start();

		// Create a new user thread and start it
		Thread userThread = new Thread(new UserThread());
		userThread.start();

	}
}
