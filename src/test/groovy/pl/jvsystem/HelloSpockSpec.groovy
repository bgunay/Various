package pl.jvsystem

import spock.lang.Specification


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
		def Person p = new Person(age: 15, name: 'Przemek')
		expect: "persion has created"
		p.name == 'Przemek'

	}
}
