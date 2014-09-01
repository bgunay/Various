package pl.jvsystem.concurrency.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CompletableFutureTest
 */
public class CompletableFutureTest {

	private static final Logger LOG = LoggerFactory.getLogger(CompletableFutureTest.class);
	@Test
	public void supplyAsync() throws ExecutionException, InterruptedException {

		final CompletableFuture<String> java = CompletableFuture.supplyAsync(() ->
			new Client().getMostRecentQuestion()
		);

		CompletableFuture<Integer> integerCompletableFuture = java.thenApply(String::length).thenApply(len -> len + 2);
		LOG.debug("Found: {}", integerCompletableFuture.get());
	}

	@Test
	public void thenAccept() throws InterruptedException {
		final CompletableFuture<String> java = CompletableFuture.supplyAsync(() ->
						new Client().getMostRecentQuestion()
		);

		java.thenAccept(str -> LOG.info("length: {}", str.length()));
		Thread.sleep(5000);
	}

	@Test
	public void thenCompose() throws InterruptedException {
		final CompletableFuture<String> java = CompletableFuture.supplyAsync(() ->
						new Client().getMostRecentQuestion()
		);

		java.thenCompose(this::upper).thenAccept(
				s ->
			LOG.info("uppercased: {}", s)
		);

		LOG.info("tutaj pisze ten kod");
		Thread.sleep(5000);
	}

	@Test
	public void thenCombine() throws InterruptedException {

		final CompletableFuture<String> java = CompletableFuture.supplyAsync(() ->
						new Client().getMostRecentQuestion()
		);

		final CompletableFuture<String> scala = CompletableFuture.supplyAsync(() ->
						new Client().getMostRecentQuestion(4000)
		);

		CompletableFuture<Integer> both = java.thenCombine(scala, (s, s2) -> s.length() + s2.length());
		both.thenAccept(integer -> LOG.info("afther both execution: {}", integer));
		Thread.sleep(5000);
	}

	@Test
	public void applyToEither() throws InterruptedException {

		final CompletableFuture<String> java = CompletableFuture.supplyAsync(() ->
						new Client().getMostRecentQuestion()
		);

		final CompletableFuture<String> scala = CompletableFuture.supplyAsync(() ->
						new Client().getMostRecentQuestion(4000)
		);

		CompletableFuture<Integer> both = java.applyToEither(scala, String::length);
		both.thenAccept(integer -> LOG.info("afther both execution: {}", integer));
		Thread.sleep(5000);

	}
	

	public CompletableFuture<String> upper(final String s) {
		return CompletableFuture.supplyAsync(s::toUpperCase);
	}

}
