package pl.jvsystem.dsl

import groovy.xml.MarkupBuilder

/**
 * MemoDSL
 */
class MemoDSL {

	String toText
	String fromText
	String body
	def books = []

	/**
	 * This method accepts a closure which is essentially the DSL. Delegate the
	 * closure methods to
	 * the DSL class so the calls can be processed
	 */
	def static build(closure) {
		MemoDSL memoDsl = new MemoDSL()
		// any method called in closure will be delegated to the memoDsl class
		closure.delegate = memoDsl
		closure()
	}

	/**
	 * Store the parameter as a variable and use it later to output a memo
	 */
	def to(String toText) {
		this.toText = toText
	}

	def from(String fromText) {
		this.fromText = fromText
	}

	def body(String bodyText) {
		this.body = bodyText
	}

	/**
	 * When a method is not recognized, assume it is a title for a new section. Create a simple
	 * object that contains the method name and the parameter which is the body.
	 */
	def methodMissing(String methodName, args) {
		def section = new Book(title: methodName, price: args[0])
		books << section
	}

	/**
	 * 'get' methods get called from the dsl by convention. Due to groovy closure delegation,
	 * we had to place MarkUpBuilder and StringWrite code in a static method as the delegate of the closure
	 * did not have access to the system.out
	 */
	def getXml() {
		doXml(this)
	}

/**
 * Use markupBuilder to create a customer xml output
 */
	private static doXml(MemoDSL memoDsl) {
		def writer = new StringWriter()
		def xml = new MarkupBuilder(writer)
		xml.memo() {
			to(memoDsl.toText)
			from(memoDsl.fromText)
			body(memoDsl.body)
			// cycle through the stored section objects to create an xml tag
			for (s in memoDsl.books) {
				"$s.title"(s.price)
			}
		}
		println writer
	}



}