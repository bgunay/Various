package com.github.pnowy.various.builders.robot

/**
 * LeftTurn
 */
class LeftTurn {
	def rotation

	@Override
	String toString() {
		"turn left ... $rotation degrees..."
	}
}
