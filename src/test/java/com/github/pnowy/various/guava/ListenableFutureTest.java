package com.github.pnowy.various.guava;

import com.github.pnowy.various.concurrency.AbstractFuturesTest;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public class ListenableFutureTest extends AbstractFuturesTest {
	private static final Logger LOG = LoggerFactory.getLogger(ListenableFutureTest.class);


	@Test
	public void should() {
		ListenableFuture futureTask = executorService.submit(() -> {
			Thread.sleep(2500L);
			LOG.info("siedzie sobie w watku i czekam...");
			Thread.sleep(2500L);
			return "Ala ma kota";
		});
		Futures.addCallback(futureTask, new FutureCallback() {
			@Override
			public void onSuccess(Object result) {
				LOG.info("success");
			}

			@Override
			public void onFailure(Throwable t) {
				LOG.info("failure");
			}
		});


	}
}
