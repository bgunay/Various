package pl.jvsystem.guava;

import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.jvsystem.concurrency.AbstractFuturesTest;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * ListenableFutureTest
 */
public class ListenableFutureTest extends AbstractFuturesTest {
	private static final Logger LOG = LoggerFactory.getLogger(ListenableFutureTest.class);


	@Test
	public void should() {
		ListenableFuture futureTask = executorService.submit(() -> {
			Thread.sleep(2500l);
			LOG.info("siedzie sobie w watku i czekam...");
			Thread.sleep(2500l);
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
