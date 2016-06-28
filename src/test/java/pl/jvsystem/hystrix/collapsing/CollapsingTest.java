package pl.jvsystem.hystrix.collapsing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rx.Observable;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

public class CollapsingTest {
    private static final Logger log = LoggerFactory.getLogger(CollapsingTest.class);

    @Test
    public void testCollapse() throws Exception {
        HystrixRequestContext requestContext = HystrixRequestContext.initializeContext();

        log.info("About to execute Collapsed command");
        List<Observable<Person>> result = new ArrayList<>();
        CountDownLatch cl = new CountDownLatch(1);
        for (int i = 1; i <= 100; i++) {
            result.add(new PersonRequestCollapser(i).observe());
        }
        Observable.merge(result)
                .subscribe(p -> log.info(p.toString()), t -> log.error(t.getMessage(), t), cl::countDown);
        cl.await();
        log.info("Completed executing Collapsed Command");
        requestContext.shutdown();
    }
}
