package pl.jvsystem.concurrency.futures;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Przemek Nowak [przemek.nowak.pl@gmail.com]
 *         Date: 2015-04-13 11:18
 */
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
