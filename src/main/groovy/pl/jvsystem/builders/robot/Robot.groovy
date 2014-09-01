package pl.jvsystem.builders.robot

/**
 * Robot
 */
class Robot {
	String name
	def movements = []

	void go() {
		println "Robot $name operating..."
		movements.each {
			movement -> println movement
		}
	}
}