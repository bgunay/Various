package com.github.pnowy.various.concurrency.futures;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class InterruptibleTask implements Runnable {

    private final CountDownLatch started = new CountDownLatch(1);
    private final CountDownLatch interrupted = new CountDownLatch(1);

    @Override
    public void run() {
        started.countDown();
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            interrupted.countDown();
        }
    }

    void blockUntilStarted() throws InterruptedException {
        started.await();
    }

    void blockUntilInterrupted() throws InterruptedException {
        assert interrupted.await(1, TimeUnit.SECONDS);
    }

}
