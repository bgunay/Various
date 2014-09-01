package pl.jvsystem.builders.robot

/**
 * LeftTurnFactory
 */
class LeftTurnFactory extends AbstractFactory {
	@Override
	Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
		new LeftTurn()
	}

	@Override
	boolean isLeaf() {
		true
	}
}
