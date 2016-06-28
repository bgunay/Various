package com.github.pnowy.various.builders

/**
 * TodoBuilderWithSupport
 */
class TodoBuilderWithSupport extends BuilderSupport {
	int level = 0
	def result = new StringWriter()

	@Override
	protected void setParent(Object parent, Object child) {}

	@Override
	protected Object createNode(Object name) {
		if (name == 'build') {
			result << "To-Do:\n"
			'buildnode'
		} else {
			handle(name, [:])
		}
	}

	@Override
	protected Object createNode(Object name, Object value) {
		throw new Exception('Invalid format')
	}

	@Override
	protected Object createNode(Object name, Map attributes) {
		handle(name, attributes)
	}

	@Override
	protected Object createNode(Object name, Map attributes, Object value) {
		throw new Exception('Invalid format')
	}

	def propertyMissing(String name) {
		handle(name, [:])
		level --
	}

	@Override
	void nodeCompleted(parent, node) {
		level--
		if (node == 'buildnode') {
			println result
		}
	}

	def handle(String name, attributes) {
		level++
		level.times { result<< "  " }
		result << placeXifStatusDone(attributes)
		result << name.replaceAll("_", " ")
		result << printParameters(attributes)
		result << "\n"
		name
	}

	def placeXifStatusDone(attributes) {
		attributes['status'] == 'done' ? "x " : "- "
	}

	def printParameters(attributes) {
		def values = ""
		if (attributes.size() > 0) {
			values += " ["
			def count = 0
			attributes.each { key, value ->
				if (key == 'status') return
				count++
				values += (count > 1 ? " " : "")
				values += "${key}: ${value}"
			}
			values += "]"
		}
		return values
	}

}
