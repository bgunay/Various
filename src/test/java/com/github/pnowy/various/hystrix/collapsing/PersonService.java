package com.github.pnowy.various.hystrix.collapsing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Person service
 */
public class PersonService {

    public Person findPerson(Integer id) {
//        try { Thread.sleep(150); } catch (InterruptedException ignore) {}
        return new Person(id, "name : " + id);
    }

    public List<Person> findPeople(List<Integer> ids) {
//        try { Thread.sleep(150); } catch (InterruptedException ignore) {}
        return ids
                .stream()
                .map(i -> new Person(i, "name : " + i))
                .collect(Collectors.toList());
    }
}
