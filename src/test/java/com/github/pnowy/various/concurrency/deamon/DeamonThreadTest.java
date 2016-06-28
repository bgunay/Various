package com.github.pnowy.various.concurrency.deamon;

/**
 * A daemon thread in Java is one that doesn't prevent the JVM from exiting.
 * Specifically the JVM will exit when only daemon threads remain.
 * You create one by calling the setDaemon() method on Thread.
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
