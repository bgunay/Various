package com.github.pnowy.various.concurrency.threadexecutor;

import org.junit.Test;

/**
 * WebCrawlerTest
 */
public class WebCrawlerTest {

	@Test
	public void threadExecutorTest() throws Exception {
		WebCrawler6 webCrawler6 = new WebCrawler6("http://www.wp.pl", 64);
		webCrawler6.startCrawling();
		System.out.println(webCrawler6.size());
		Thread.sleep(5000);

		System.out.println(webCrawler6.size());
	}

}
