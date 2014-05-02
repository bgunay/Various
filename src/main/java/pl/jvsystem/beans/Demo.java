package pl.jvsystem.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.jvsystem.generic.Box;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

/**
 * Przemek Nowak <przemek.nowak.pl@gmail.com>
 * Date: 20.12.13 21:38
 */
public class Demo
{
	private static final Logger LOG = LoggerFactory.getLogger(Demo.class);

	public static void main(String[] args) throws IntrospectionException
	{
		BeanInfo beanInfo = Introspector.getBeanInfo(Box.class);
		LOG.debug("beanInfo: {}", beanInfo.getMethodDescriptors().length);
	}
}
