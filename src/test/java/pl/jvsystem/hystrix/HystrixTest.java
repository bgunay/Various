package pl.jvsystem.hystrix;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandMetrics;
import com.netflix.hystrix.HystrixRequestLog;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;

import java.util.concurrent.Future;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Przemek Nowak [przemek.nowak.pl@gmail.com]
 *         Date: 2015-04-01 11:58
 */
public class HystrixTest {

    private static final Logger LOG = LoggerFactory.getLogger(HystrixTest.class);

    @Test
    public void testCommandExecution() throws Exception {
        HystrixCommand<String> command = new HelloWorldCommand();
        LOG.info("main thread: {}", Thread.currentThread().getName());

        String result = command.execute();
        LOG.info("synchronous result: {}", result);

        Future<String> stringFuture = new HelloWorldCommand().queue();
        LOG.info("asynchronous result: {}", stringFuture.get());

        HystrixCommand<String> obsCommand = new HelloWorldCommand();
        Observable<String> observable = obsCommand.observe();
        observable.subscribe(s -> {
            LOG.info("from observable: {}", s);
        });
    }

    @Test
    public void testCircuitBreaker() throws Exception {
        //Initialize HystrixRequestContext to be able to get some metrics
        HystrixRequestContext context = HystrixRequestContext.initializeContext();

        //We use Archaius to set the circuit as closed.
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.circuitBreaker.forceOpen", false);

        String successMessage = new HelloWorldCommand().execute();
        assertThat(successMessage, is("Hello World"));

        //We use Archaius to open the circuit
        ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.circuitBreaker.forceOpen", true);

        String failMessage = new HelloWorldCommand().execute();
        assertThat(failMessage, is("Good Bye"));

        //Prints Request => HelloWorldRestCommand[SUCCESS][19ms], HelloWorldRestCommand[SHORT_CIRCUITED, FALLBACK_SUCCESS][0ms]
        LOG.info("Requests => {}", HystrixRequestLog.getCurrentRequest().getExecutedCommandsAsString());

        HystrixCommandMetrics hystrixMetrics = HystrixCommandMetrics.getInstance(HystrixCommandKey.Factory.asKey(HelloWorldCommand.class.getSimpleName()));
        assertThat(hystrixMetrics.getHealthCounts().getTotalRequests(), is(2L));
        assertThat(hystrixMetrics.getHealthCounts().getErrorCount(), is(1L));

        context.shutdown();

    }
}
