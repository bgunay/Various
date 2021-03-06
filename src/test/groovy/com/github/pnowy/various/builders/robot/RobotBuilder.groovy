package com.github.pnowy.various.builders.robot

/**
 * Robot Builder
 */
class RobotBuilder extends FactoryBuilderSupport {

	{
		registerFactory('robot', new RobotFactory())
		registerFactory('forward', new ForwardMoveFactory())
		registerFactory('left', new LeftTurnFactory())
	};

}
