package pl.jvsystem.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Przemek Nowak [przemek.nowak.pl@gmail.com]
 *         Date: 2015-04-01 11:57
 */
public class HelloWorldCommand extends HystrixCommand<String> {
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldCommand.class);

    protected HelloWorldCommand() {
        super(HystrixCommandGroupKey.Factory.asKey(HelloWorldCommand.class.getSimpleName()));
    }

    @Override
    protected String run() throws Exception {
        LOG.info("{}", Thread.currentThread().getName());
//        throw new IllegalStateException("we should do something");
        Thread.sleep(500);
        return "Hello World";
    }

    @Override
    protected String getFallback() {
        return "Good Bye";
    }
}
