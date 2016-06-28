package com.github.pnowy.various.concurrency.futures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {

	private static final Logger LOG = LoggerFactory.getLogger(Client.class);

	public String getMostRecentQuestion() {
		return getMostRecentQuestion(2000);
	}

	public String getMostRecentQuestion(int sleep) {
		LOG.info("getting most recent question...");
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "To be or not to be?";
	}

}
