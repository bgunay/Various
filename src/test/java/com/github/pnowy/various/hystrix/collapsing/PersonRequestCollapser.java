package com.github.pnowy.various.hystrix.collapsing;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCollapserKey;
import com.netflix.hystrix.HystrixCollapserProperties;
import com.netflix.hystrix.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Przemek Nowak [przemek dot nowak dot pl at gmail.com]
 */
public class PersonRequestCollapser extends HystrixCollapser<List<Person>, Person, Integer> {
    private static final Logger log = LoggerFactory.getLogger(PersonRequestCollapser.class);
    private final Integer id;

    public PersonRequestCollapser(Integer id) {
        super(Setter.
                withCollapserKey(HystrixCollapserKey.Factory.asKey("personRequestCollapser"))
                .andCollapserPropertiesDefaults(HystrixCollapserProperties.Setter().withTimerDelayInMilliseconds(2000)));
        this.id = id;
    }

    @Override
    public Integer getRequestArgument() {
        return this.id;
    }

    @Override
    protected HystrixCommand<List<Person>> createCommand(Collection<CollapsedRequest<Person, Integer>> collapsedRequests) {
        log.info("Creating command on request collapser!");
        List<Integer> ids = collapsedRequests.stream().map(CollapsedRequest::getArgument).collect(toList());
        return new PersonRequestCommand(ids);
    }

    @Override
    protected void mapResponseToRequests(List<Person> batchResponse, Collection<CollapsedRequest<Person, Integer>> collapsedRequests) {
        log.info("Divide batch response to single request responses!");
        Map<Integer, Person> personMap = batchResponse.stream().collect(Collectors.toMap(Person::getId, Function.identity()));

        for (CollapsedRequest<Person, Integer> cr: collapsedRequests) {
            cr.setResponse(personMap.get(cr.getArgument()));
        }
    }
}
