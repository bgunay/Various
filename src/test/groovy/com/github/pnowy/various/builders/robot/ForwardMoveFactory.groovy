package com.github.pnowy.various.builders.robot

/**
 * ForwardMoveFactory
 */
class ForwardMoveFactory extends AbstractFactory {
	@Override
	Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
		new ForwardMove()
	}

	@Override
	boolean isLeaf() {
		true
	}

	@Override
	boolean onHandleNodeAttributes(FactoryBuilderSupport builder, Object node, Map attributes) {
		if (attributes.speed && attributes.duration) {
			node.dist = attributes.speed * attributes.duration
			attributes.remove('speed')
			attributes.remove('duration')
		}
		true
	}
}
