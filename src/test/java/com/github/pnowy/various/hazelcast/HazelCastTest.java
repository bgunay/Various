package com.github.pnowy.various.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.junit.Test;

public class HazelCastTest {

    @Test
    public void testInstances() throws Exception {
        HazelcastInstance firstInstance = Hazelcast.newHazelcastInstance(new Config());
        HazelcastInstance secondInstance = Hazelcast.newHazelcastInstance(new Config());

        // Introducing a sample data in a map using the first instance
        firstInstance.getMap("TEST_MAP").put("key", "test_value");

        // Prints the value using the second instance. The result will be 'test_value'
        System.out.println(secondInstance.getMap("TEST_MAP").get("key"));

        Thread.sleep(5000);

    }
}
