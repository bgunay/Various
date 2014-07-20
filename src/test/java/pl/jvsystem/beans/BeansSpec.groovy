package pl.jvsystem.beans

import groovy.util.logging.Slf4j
import pl.jvsystem.generic.Box
import spock.lang.Specification

import java.beans.BeanInfo
import java.beans.Introspector


/**
 * BeansSpec
 */
@Slf4j(value = "LOG")
class BeansSpec extends Specification {

	def "should return bean info"() {
		given:
		BeanInfo beanInfo = Introspector.getBeanInfo(Box.class);
		expect:
		LOG.debug("beanInfo: {}", beanInfo.getMethodDescriptors().length);
		LOG.debug("beanInfo: {}", beanInfo.getBeanDescriptor().getShortDescription())
	}

}