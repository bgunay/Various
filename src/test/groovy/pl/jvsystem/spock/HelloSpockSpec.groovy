package pl.jvsystem.spock

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

	def "person test"() {
		given: "a new person class is created"
		def Person p = new Person(age: 15, firstName: 'Przemek')
		expect: "person has firstName Przemek"
		p.firstName == 'Przemek'
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

}
