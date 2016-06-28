package com.github.pnowy.various.json

import groovy.json.JsonSlurper
def reader = new FileReader('items.json')
def ui = new JsonSlurper().parse(reader)

ui.items.each { println it.type }

println ui.items[0]
		.axes
		.find {
	it.fields.contains('y')
}.title