package pl.jvsystem.beans.meanbean;

/**
 * MyBeanTest
 */
public class MyBeanTest extends AbstractJavaBeanTest<MyBean> {

	@Override
	protected MyBean getBeanInstance() {
		return new MyBean();
	}
}
