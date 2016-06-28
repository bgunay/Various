package pl.jvsystem.beans;

import lombok.extern.slf4j.Slf4j;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;
import org.meanbean.lang.Factory;
import org.meanbean.test.BeanTester;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

@Slf4j
public class ExampleBeanTest {

	@Test
	public void beanIsSerializable() throws Exception {
		final ExampleBean exampleBean = getBeanInstance();
		final byte[] serializedMyBean = SerializationUtils.serialize(exampleBean);
		@SuppressWarnings("unchecked")
		final ExampleBean deserializedExampleBean = SerializationUtils.deserialize(serializedMyBean);
		assertEquals(exampleBean, deserializedExampleBean);
	}

	@Test
	public void equalsAndHashCodeContract() {
		EqualsVerifier.forClass(getBeanInstance().getClass()).suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();
	}

	@Test
	public void getterAndSetterCorrectness() throws Exception {
		final BeanTester beanTester = new BeanTester();
		beanTester.getFactoryCollection().addFactory(LocalDateTime.class, new LocalDateTimeFactory());
		beanTester.testBean(getBeanInstance().getClass());
	}

	@Test
	public void  shouldReturnBeanInfo() throws Exception {
		BeanInfo beanInfo = Introspector.getBeanInfo(ExampleBean.class);
		log.debug("beanInfo: {}", beanInfo.getMethodDescriptors().length);
		log.debug("beanInfo: {}", beanInfo.getBeanDescriptor().getShortDescription());
	}

	/**
	 * Concrete Factory that creates a LocalDateTime.
	 */
	private class LocalDateTimeFactory implements Factory {
		@Override
		public LocalDateTime create() {
			return LocalDateTime.now();
		}

	}

	private ExampleBean getBeanInstance() {
		return new ExampleBean();
	}
}
