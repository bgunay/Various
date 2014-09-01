package pl.jvsystem.builders.robot

/**
 * RobotFactory
 */
class RobotFactory extends AbstractFactory {
	@Override
	Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
		new Robot(name: value)
	}

	@Override
	void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
		parent.movements << child
	}
}
