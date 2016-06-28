package com.github.pnowy.various.concurrency.rxjava;

import com.github.pnowy.various.concurrency.AbstractFuturesTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RxBaseTest extends AbstractFuturesTest {
	private static final Logger log = LoggerFactory.getLogger(RxBaseTest.class);

	@Test
	public void helloWorldTest() {
		Observable<String> myObservable = Observable.create(new Observable.OnSubscribe<String>() {
			@Override
			public void call(Subscriber<? super String> subscriber) {
				subscriber.onNext("Hello world!");
				subscriber.onCompleted();
			}
		});

		Subscriber<String> mySubscriber = new Subscriber<String>() {
			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable e) {

			}

			@Override
			public void onNext(String s) {
				log.info(s);
			}
		};

		myObservable.subscribe(mySubscriber);
	}

	@Test
	public void helloWorldSimplified() {
		Observable<String> myObservable = Observable.just("Hello");

		Action1<String> onNextAction = new Action1<String>() {
			@Override
			public void call(String s) {
				log.info(s);
			}
		};
		myObservable.subscribe(onNextAction);
	}

	@Test
	public void helloWorldSimplified2() {
		Observable.just("Hello").subscribe(log::info);
	}

	@Test
	public void testMapOperator() {
//		Observable.just("Hello").map(String::toUpperCase).subscribe(log::info);
//		Observable.just("Hello").map(String::hashCode).subscribe(hashCode -> log.info("Value of hashCode: {}", hashCode));
//		Observable.from()
//				.flatMap(Observable::from)
//				.subscribe(n -> log.info(n))
//		;

		query()
			.flatMap(Observable::from)
			.subscribe(urls -> log.info("query element: {}", urls));

	}

	private Observable<List<String>> query() {
		return Observable.just(Arrays.asList("one", "two", "three"), Arrays.asList("four", "five", "six"));
	}


	@Test
	public void emptyTest() {
		Observable.create(new Observable.OnSubscribe<Integer>() {
			@Override
			public void call(Subscriber<? super Integer> observer) {
				try {
					if (!observer.isUnsubscribed()) {
						for (int i = 1; i < 5; i++) {
							observer.onNext(i);
						}
						observer.onNext(34);
						observer.onCompleted();
					}
				} catch (Exception e) {
					observer.onError(e);
				}
			}
		} ).subscribe(new Subscriber<Integer>() {
			@Override
			public void onNext(Integer item) {
				System.out.println("Next: " + item);
			}

			@Override
			public void onError(Throwable error) {
				System.err.println("Error: " + error.getMessage());
			}

			@Override
			public void onCompleted() {
				System.out.println("Sequence complete.");
			}
		});

	}

	@Test
	public void someRxJavaTests() throws Exception {
		//List<String> list = IntStream.range(0, 10).boxed().map(this::generateTask).collect(toList());
//
//		List<CompletableFuture<String>> futures =
//		IntStream.range(0, 10)
//				.boxed()
//				.map(i -> this.generateTask(i, executorService).exceptionally(t -> t.getMessage()))
//				.collect(toList());
//
//		CompletableFuture<List<String>> list = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
//				.thenApply(v -> futures.stream().map(CompletableFuture::join).collect(toList()));
//
//		list.thenAccept(l -> log.info("{}", l.toString()));

		List<Observable<String>> obs = IntStream.range(0, 10).boxed().map(i -> generateRxTask(i, executorService)).collect(toList());
		Observable<List<String>> merged = Observable.merge(obs).toList();
		merged.subscribe(l -> log.info(l.toString()));

//		log.info("{}", list);
	}

	private String generateTask(int i) {
		sleep(2000);
		return i + "-" + "test";
	}

	private CompletableFuture<String> generateTask(int i, ExecutorService executorService) {
		return CompletableFuture.supplyAsync(() -> {
			sleep(2000);
			if (i == 5) {
				throw new RuntimeException("Run, it is a 5!");
			}
			return i + "-" + "test";
		}, executorService);
	}

	private Observable<String> generateRxTask(int i, ExecutorService executorService) {
		return Observable.<String>create(s -> {
					sleep(2000);
					if ( i == 5) {
						throw new RuntimeException("Run, it is a 5!");
					}
					s.onNext( i + "-test");
					s.onCompleted();
				}).onErrorReturn(e -> e.getMessage())
				.subscribeOn(Schedulers.from(executorService));
	}


	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException ignore) {}
	}


}
