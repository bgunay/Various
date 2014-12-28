package pl.jvsystem.yaml;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Map;

import org.junit.Test;

import com.esotericsoftware.yamlbeans.YamlReader;

/**
 * YamlReading
 */
public class YamlReadingTest {


	@Test
	public void readYamlTest() throws Exception {
		YamlReader reader = new YamlReader(new InputStreamReader(YamlReadingTest.class.getResourceAsStream("/queryMapping.yaml")));
		Map<String, Map<String, String>> object = reader.read(Map.class);
//		Object object = reader.read();
		System.out.println(object);
		//Map map = (Map) object;
		System.out.println(object.get("sampleId").get("WP"));
	}

	@Test
	public void readYamlPhones() throws Exception {
		YamlReader reader = new YamlReader(new InputStreamReader(YamlReadingTest.class.getResourceAsStream("/phones.yaml")));
		Object object = reader.read();
		System.out.println(object);
	}

}
