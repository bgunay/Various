package pl.jvsystem.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class HelloWorldCommand extends HystrixCommand<String> {
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldCommand.class);

    HelloWorldCommand() {
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
