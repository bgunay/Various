package com.github.pnowy.various.builders.robot

def builder = new RobotBuilder()
def robot = builder.robot('iRobot') {
	forward(dist: 20)
	left(rotation: 90)
	forward(speed: 10, duration: 5)
}

robot.go()