package pl.jvsystem.java8;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Date: 2014-05-03 17:36
 */
public class NewMapApiTest {
	private static final Logger LOG = LoggerFactory.getLogger(NewMapApiTest.class);

	@Test
	public void testNewMethods() throws Exception {
		Map<Integer, String> map = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "val" + i);
		}

		map.forEach((key, val) -> LOG.info("key: {}, value: {}", key, val));

		map.computeIfPresent(3, (key, val) -> key + val);
		LOG.info("Map.get(3): {}", map.get(3));
		map.remove(3, "3val3");
		assertThat(map.get(3)).isNull();
		assertThat(map.getOrDefault(3, "not found")).isEqualTo("not found");

		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		LOG.info(map.get(9));
	}
}
