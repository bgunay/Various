package com.github.pnowy.various.spock

import pl.jvsystem.domain.Person
import spock.lang.Specification
import spock.lang.Unroll


class HelloSpockSpec extends Specification {
	def "length of Spock's and his friends' names"() {
		expect:
		name.size() == length

		where:
		name     | length
		"Spock"  | 5
		"Kirk"   | 4
		"Scotty" | 6
	}

	@Unroll
	def "maximum of #a and #b is #c"() {
		expect:
		Math.max(a, b) == c
		where:
		a | b || c
		1 | 3 || 3
		7 | 4 || 7
		0 | 0 || 0
	}

	def "person test"() {
		given: "a new person class is created"
		def Person p = new Person(age: 15, firstName: 'Przemek')
		expect: "person has firstName Przemek"
		p.firstName == 'Przemek'
	}


	def "comparison of two integer"() {
		given:
		final int STATUS_ELEMENT_DUBEL= 5
		Integer elementStatus = Integer.valueOf(5)
		when:
		boolean result = elementStatus == STATUS_ELEMENT_DUBEL
		then:
		result
	}

	def "big integer test"() {
		expect:
		BigDecimal bd = new BigDecimal(new BigInteger(1224), 2); // expected amount 12.24
		println bd											// 12.24
		println bd.unscaledValue().toString() 				// 1224

		def bd3 = bd.setScale(3, BigDecimal.ROUND_DOWN)		// someone use the scale 3 to convert to unscaled value which is sent to kerne
		println bd3 										// 12.240
		println bd3.unscaledValue().toString();				// 12240 in that way we get additional zero on amount
	}

}
