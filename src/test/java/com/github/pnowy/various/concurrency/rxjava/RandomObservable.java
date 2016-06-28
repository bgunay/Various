package com.github.pnowy.various.concurrency.rxjava;

import rx.Observable;

import java.util.Random;

class RandomObservable extends Observable<Integer> {

	protected RandomObservable() {
		super(subscriber -> {
			Random random = new Random();
			while (!subscriber.isUnsubscribed()) {
				subscriber.onNext(random.nextInt());
			}
		});
	}
}
